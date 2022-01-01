import java.util.regex.Pattern;

class Solution {

    private static final Pattern letterRegex = Pattern.compile("[^a-zA-Z0-9_.-]");
    private static final Pattern DotsRegex = Pattern.compile("[.]{2,}");
    private static final Pattern frontDotRegex = Pattern.compile("^[.]");
    private static final Pattern backDotRegex = Pattern.compile("[.]$");
    private static final Pattern bothEndsDotsRegex = Pattern.compile("^[.]|[.]$");

    public String solution(String new_id) {

        return new RecommendationID(new_id)
                .toLowerCase()
                .removeUnavailableLetter()
                .changeDotsIntoOneDot()
                .removeFrontDot()
                .removeBackDot()
                .insertIfEmpty()
                .removeIfMoreThan15()
                .addIfLessThan2()
                .get();
    }

    private class RecommendationID{

        private String id;

        private String get(){
            return this.id;
        }
        public RecommendationID(String id){
            this.id = id;
        }

        private RecommendationID toLowerCase(){
            this.id = id.toLowerCase();
            return this;
        }

        private RecommendationID removeUnavailableLetter(){
//            this.id = id.replaceAll("[^a-zA-Z0-9_.-]","");
            this.id = letterRegex.matcher(this.id).replaceAll("");
            return this;
        }

        private RecommendationID changeDotsIntoOneDot(){
//            this.id = id.replaceAll("[.]{2,}",".");
            this.id = DotsRegex.matcher(this.id).replaceAll(".");

            return this;
        }

        private RecommendationID removeFrontDot(){
//            this.id = id.replaceAll("^[.]","");
            this.id = frontDotRegex.matcher(this.id).replaceAll("");

            return this;
        }

        private RecommendationID removeBackDot(){
//            this.id = id.replaceAll("[.]$","");
            this.id = backDotRegex.matcher(this.id).replaceAll("");

            return this;
        }

        private RecommendationID insertIfEmpty(){
            if(this.id.equals("")) this.id = String.valueOf("a");
            return this;
        }

        private RecommendationID removeIfMoreThan15(){
            if(this.id.length() >= 16) {
//                this.id = this.id.substring(0,15).replaceAll("^[.]|[.]$","");
                this.id = bothEndsDotsRegex.matcher(this.id.substring(0,15)).replaceAll("");

            }
            return this;
        }

        private RecommendationID addIfLessThan2(){
            while(this.id.length() <= 2) this.id += this.id.charAt(this.id.length()-1);
            return this;
        }
    }
}