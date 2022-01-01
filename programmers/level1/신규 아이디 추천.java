class Solution {
    
    public String solution(String new_id) {
        String answer = "";
        String processingId = new_id;

        processingId = executeStep1(processingId);    //대문자 -> 소문자
        processingId = executeStep2(processingId);    //알파벳,.,-,_ 문자를 제외한 문자 제거
        processingId = executeStep3(processingId);    //연속적인 '.' 제거
        processingId = executeStep4(processingId);    //맨앞뒤 '.' 제거
        processingId = executeStep5(processingId);    //빈문자열 처리
        processingId = executeStep6(processingId);    //길이 16이상일 때 자르기
        processingId = executeStep7(processingId);    //길이 2 이하일 때 처리

        answer = processingId;

        return answer;
    }

    //대문자 -> 소문자
    private String executeStep1(String id){
        return id.toLowerCase();
    }

    //알파벳,.,-,_ 문자를 제외한 문자 제거
 private String executeStep2(String id){
        char[] charArrayId = id.toCharArray();

        int index = 0;
        for(char ch: charArrayId){
            if(!Character.isAlphabetic(ch) && !Character.isDigit(ch)){
                if(ch != '-' && ch != '_' && ch !='.'){
                    charArrayId[index] = ' ';
                }
            }
            index++;
        }
        "asdf".replace

        return String.valueOf(charArrayId).replace(" ","");

    }

    //연속적인 '.' 제거
    private String executeStep3(String id){
        StringBuilder processingId = new StringBuilder(id);
        int startDotsIndex = processingId.indexOf("..");

        while(processingId.indexOf("..") != -1){
            processingId = processingId.replace(startDotsIndex,startDotsIndex+2,".");
            startDotsIndex = processingId.indexOf("..");
        }

        return processingId.toString();
    }

    //맨앞뒤 '.' 제거
    private String executeStep4(String id) {
        if(id.length() != 0) {
            if(id.charAt(0) == '.') id = new StringBuilder(id).deleteCharAt(0).toString();
        }
        if(id.length() != 0) {
            if(id.charAt(id.length() - 1) == '.') id = new StringBuilder(id).deleteCharAt(id.length() - 1).toString();
        }

        return id;
    }

    //빈문자열 처리
    private String executeStep5(String id) {
        if(id.length() == 0) return new StringBuilder(id).append('a').toString();

        return id;
    }

    //길이 16이상일 때 자르기
    private String executeStep6(String id) {
        if(id.length() > 15) id = id.substring(0,15);
        if(id.charAt(id.length() - 1) == '.') id = id.substring(0,id.length()-1);

        return id;
    }

    //길이 2 이하일 때 처리
    private String executeStep7(String id) {
        if(id.length() < 3){
            StringBuilder processingId = new StringBuilder(id);
            char lastChar = processingId.charAt(processingId.length() - 1);
            while(processingId.length() < 3){
                processingId.append(lastChar);
            }

            return processingId.toString();
        }

        return id;
    }
}