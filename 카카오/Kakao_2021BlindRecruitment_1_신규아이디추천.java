public class Kakao_2021BlindRecruitment_1_신규아이디추천 {
    public String solution(String new_id) {
        return recommendNewId(new_id);
    }
    private static String recommendNewId(String id) {
        return new Recommand(id)
                .changeUpperToLower()
                .eraseInvalidChar()
                .replaceContinuousColon()
                .eraseSideColon()
                .checkEmpty()
                .checkOverflowSize()
                .resizeId()
                .getId();
    }

    private static class Recommand{
        private String id;
        public Recommand(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }
        private Recommand resizeId() {
            if (id.length() > 2) {
                return this;
            }
            StringBuilder output = new StringBuilder(id);
            while (output.length() <= 2) {
                output.append(id.charAt(id.length() - 1));
            }
            this.id = output.toString();
            return this;
        }
        private Recommand checkOverflowSize() {
            String newId = this.id.length() >= 16 ? this.id.substring(0, 15) : this.id;
            int idx = newId.length() - 1;
            for (int i = newId.length() - 1; i >= 0; i--) {
                if (newId.charAt(i) != '.') {
                    idx = i;
                    break;
                }
            }
            this.id = newId.substring(0, idx + 1);
            return this;
        }
        private Recommand checkEmpty() {
            this.id = this.id.length() == 0 ? "a" : this.id;
            return this;
        }
        private Recommand eraseSideColon() {
            if (this.id.length() == 0) return this;
            String newId = this.id.charAt(0) == '.' ? this.id.substring(1) : this.id;
            if (newId.length() == 0) {
                this.id = newId;
                return this;
            }
            newId = newId.charAt(newId.length() - 1) == '.' ? newId.substring(0, newId.length() - 1) : newId;
            this.id = newId;
            return this;
        }
        private Recommand replaceContinuousColon() {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < id.length(); i++) {
                char c = id.charAt(i);
                if (i != 0 && c == '.' && id.charAt(i - 1) == '.') {
                    continue;
                }
                output.append(c);
            }
            this.id = output.toString();
            return this;
        }
        private Recommand changeUpperToLower() {
            StringBuilder output = new StringBuilder();
            for (char c : this.id.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    output.append(Character.toLowerCase(c));
                } else {
                    output.append(c);
                }
            }
            this.id = output.toString();
            return this;
        }

        private Recommand eraseInvalidChar() {
            StringBuilder output = new StringBuilder();
            for (char c : this.id.toCharArray()) {
                if (Character.isDigit(c) || Character.isLowerCase(c) ||
                        c == '-' || c == '_' || c == '.') {
                    output.append(c);
                }
            }
            this.id = output.toString();
            return this;
        }
    }
}
