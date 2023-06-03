package src.org.modle;


/**
 * 
 * @L_fanhua
 * @v0.1.0bate
 */
import src.org.modle.Log;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class InviteCode {
        private static Log log = new Log("invitecode");
        private static  List<String> inviteCodes = new ArrayList<>();
        //邀请码暂时存储与此列表中
        public static String randomer() {
            Random random = new Random();
             
            StringBuilder stringBuilder = new StringBuilder();
            

            for (int i = 0; i < 20; i++) {
                int digit = random.nextInt(10);
                stringBuilder.append(digit);
            }

            String randomNumber = stringBuilder.toString();
            return randomNumber;
        }
        //生成随机数
        public static void create() {
            String inviteCode = randomer();
            inviteCodes.add(inviteCode);
            log.info("生成邀请码：" + inviteCode);
        }
        //生成邀请码并储存
        public static boolean check(String input) {
            if (inviteCodes.contains(input)) {
                inviteCodes.remove(input);
                System.out.println("邀请码有效");
                return true;
            } else {
                System.out.println("邀请码无效");
                return false;
            }
        }
        //验证邀请码
        
        
    }
