package utils.mail;

import parm.MailStru;
import utils.internal.LogInfo;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;


public class SendMailUtil {

        private String toChinese(String text) {
            try {
                text = MimeUtility.encodeText(new String(text.getBytes(), "GB2312"), "GB2312", "B");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return text;
        }

        public boolean sendMail(MailStru map) {

            String username = map.getUsername();
            String password = map.getPassword();
            String from = map.getFrom();
            String to = map.getTo();
            String subject = map.getSubject();
            String content = map.getContent();
            String fileName = map.getFileName();
            Vector<String> file = map.getFile();
            Properties props = System.getProperties();
            props.put("mail.smtp.host", map.getHost()); // 设置SMTP的主机
            props.put("mail.smtp.auth", "true"); // 需要经过验证

            Session session = Session.getInstance(props, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = { new InternetAddress(to) };
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(toChinese(subject));

                Multipart mp = new MimeMultipart();
                MimeBodyPart mappContent = new MimeBodyPart();
                mappContent.setText(content);
                mp.addBodyPart(mappContent);

            /* 往邮件中添加附件 */
                if (file != null) {
                    Enumeration<String> efile = file.elements();
                    while (efile.hasMoreElements()) {
                        MimeBodyPart mappFile = new MimeBodyPart();
                        fileName = efile.nextElement().toString();
                        FileDataSource fds = new FileDataSource(fileName);
                        mappFile.setDataHandler(new DataHandler(fds));
                        mappFile.setFileName(toChinese(fds.getName()));
                        mp.addBodyPart(mappFile);
                    }
                    LogInfo.info("Add Attachments File");
                }

                msg.setContent(mp);
                msg.setSentDate(new Date());
                Transport.send(msg);

            } catch (MessagingException me) {

                LogInfo.error(me.getMessage());

                LogInfo.info("Send Email Fail");
                return false;
            }

            LogInfo.info("Send Email Succeed");

            return true;

        }

    }

