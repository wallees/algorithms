// 문제 : ./problem/dieselmania.crypto
// 암호 : dieselmania

public class App {

    public static void main(String[] args) throws Exception {

        int[] arr1 = {5,3,4,6,7,9,19,18,17,16,12,14,15,20,13};
        int[] arr2 = {1,2,3,3,4,5,5,6,7,7,8,9,10,1};
        int[] arr3 = {5,6,7,8};


        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
    }

    public static int solution(int[] arr) {

        int buyPrice = 0;
        int sellPrice = 0;

        int[] updown = new int[arr.length]; // 지난값에 비해 얼마나 변화하였는지만 체크
        /*
         * updown이 완성되었을 때의 예시
         * arr1 : 0 -1 1 2 3 4 5 -1 -2 -3 -4 1 2 3 -1 
         * arr2 : 0 1 2 0 1 2 0 1 2 0 1 2 3 -1 
         * arr3 : 0 1 2 3 
         */

        for(int i=1; i<arr.length; i++) {
            // 증가
            if(arr[i] > arr[i-1]) {
                if(updown[i-1] > 0) {
                    updown[i] = updown[i-1] + 1;
                } else {
                    // 처음으로 증가한 경우 -> 1
                    updown[i] = 1;
                }
            // 감소
            } else if(arr[i] < arr[i-1]) {
                if(updown[i-1] < 0) {
                    updown[i] = updown[i-1] - 1;
                } else {
                    // 처음으로 감소한 경우 -> -1
                    updown[i] = -1;
                }
            } 

            // 연속해서 3번 증가 -> 매수
            if(updown[i] == 3) {
                buyPrice += arr[i];
            }
            // 연속해서 3번 하락 -> 매도
            if(updown[i] == -3) {
                sellPrice += arr[i];
            }
        }
        // 최종 매수 가격 - 최종 매도 가격 - 마지막날 가격
        return buyPrice - sellPrice - arr[arr.length-1];
    }
}
