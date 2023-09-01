import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int test = numUniqueEmails(emails);
        System.out.println(test);
    }

    public static int numUniqueEmails (String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder cleanMail = new StringBuilder();
            for (int i = 0; i < email.length(); ++i) {
                char currChar = email.charAt(i);
                if (currChar == '+' || currChar == '@') break;
                if (currChar != '.') cleanMail.append(currChar);
            }
            StringBuilder domainName = new StringBuilder();
            for (int i = email.length() - 1; i >= 0; --i) {
                char currChar = email.charAt(i);
                domainName.append(currChar);
                if (currChar == '@') break;
            }
            domainName = domainName.reverse();
            cleanMail.append(domainName);
            uniqueEmails.add(cleanMail.toString());
        }
        return uniqueEmails.size();
    }
}