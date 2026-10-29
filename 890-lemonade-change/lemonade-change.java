
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int c5 = 0;
        int c10 = 0;

        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == 5) {
                c5++;
            }
            else if (bills[i] == 10) {
                if (c5 == 0) {
                    return false;
                }

                c5--;
                c10++;
            }
            else if (bills[i] == 20) {

                // Prefer using one $10 and one $5
                if (c10 >= 1 && c5 >= 1) {
                    c10--;
                    c5--;
                }
                // Otherwise, use three $5 bills
                else if (c5 >= 3) {
                    c5 -= 3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
