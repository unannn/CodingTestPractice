class Solution {
    
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
            this.id = id.replaceAll("[^a-zA-Z0-9_.-]","");
            return this;
        }

        private RecommendationID changeDotsIntoOneDot(){
            this.id = id.replaceAll("[.]{2,}",".");
            return this;
        }

        private RecommendationID removeFrontDot(){
            this.id = id.replaceAll("^[.]","");
            return this;
        }

        private RecommendationID removeBackDot(){
            this.id = id.replaceAll("[.]$","");
            return this;
        }

        private RecommendationID insertIfEmpty(){
            if(this.id.equals("")) this.id = String.valueOf("a");
            return this;
        }

        private RecommendationID removeIfMoreThan15(){
            if(this.id.length() >= 16) this.id = this.id.substring(0,15).replaceAll("^[.]|[.]$","");
            return this;
        }

        private RecommendationID addIfLessThan2(){
            while(this.id.length() <= 2) this.id += this.id.charAt(this.id.length()-1);
            return this;
        }
    }
}