//m1 

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (String email : emails) {
            int atIndex = email.indexOf('@');

            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);

            for (char c : local.toCharArray()) {
                if (c == '+') break;
                if (c != '.') {
                    sb.append(c);
                }
            }

            sb.append(domain);
            set.add(sb.toString());
            sb.setLength(0);
        }

        return set.size();
    }
}



// m2 

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (String email : emails) {
            int atIndex = email.indexOf('@');

            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);

            for (char c : local.toCharArray()) {
                if (c == '+') break;
                if (c != '.') {
                    sb.append(c);
                }
            }

            sb.append(domain);
            set.add(sb.toString());
            sb.setLength(0);
        }

        return set.size();
    }
}