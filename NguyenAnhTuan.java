class DiscreteSignal {
    private int[] signalValues;
    
    // Constructor khởi tạo tín hiệu rời rạc
    public DiscreteSignal(int[] values) {
        this.signalValues = values;
    }
    
    // Hàm trả về giá trị tín hiệu tại thời điểm n
    public int getSignalAt(int n) {
        int sum = 0;
        for (int k = 0; k < signalValues.length; k++) {
            sum += signalValues[k] * delta(n - k);
        }
        return sum;
    }
    
    // Hàm xung đơn vị δ(n)
    private int delta(int n) {
        return (n == 0) ? 1 : 0;
    }
    
    // Hàm in tín hiệu từ n = 0 đến N
    public void printSignal(int N) {
        for (int n = 0; n <= N; n++) {
            System.out.println("x(" + n + ") = " + getSignalAt(n));
        }
    }
}

class Radar {
    // Hàm trả về giá trị tín hiệu mẫu X(n)
    public double getSignalAt(int n) {
        if (n >= 0 && n <= 15) {
            return 1 - (n / 15.0);
        } else {
            return 0;
        }
    }
    
    // Hàm in tín hiệu từ n = 0 đến N
    public void printSignal(int N) {
        for (int n = 0; n <= N; n++) {
            System.out.println("X(" + n + ") = " + getSignalAt(n));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Tạo tín hiệu rời rạc với mảng mẫu
        int[] signalValues = {1, 2, 3, 4};
        DiscreteSignal discreteSignal = new DiscreteSignal(signalValues);
        
        // In tín hiệu rời rạc
        System.out.println("Tín hiệu rời rạc:");
        discreteSignal.printSignal(4);
        
        // Tạo đối tượng Radar để phân tích tín hiệu
        Radar radar = new Radar();
        
        // In tín hiệu mẫu từ n = 0 đến n = 15
        System.out.println("\nTín hiệu mẫu radar:");
        radar.printSignal(15);
    }
}
