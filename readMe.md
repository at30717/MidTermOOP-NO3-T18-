package baitapgiuakyoop;
// Giao diện Signal đại diện cho một tín hiệu cơ bản
interface Signal {
    double getAmplitude();  // Lấy giá trị biên độ của tín hiệu
    double getFrequency();  // Lấy giá trị tần số của tín hiệu
    double getPeriod();     // Lấy giá trị chu kỳ của tín hiệu
}

// Lớp DiscreteSignal đại diện cho tín hiệu rời rạc, kế thừa giao diện Signal
class DiscreteSignal implements Signal {
    private double amplitude;  // Biên độ của tín hiệu rời rạc
    private double frequency;  // Tần số của tín hiệu rời rạc
    private double period;     // Chu kỳ của tín hiệu rời rạc

    // Constructor để khởi tạo tín hiệu rời rạc với giá trị biên độ, tần số và chu kỳ
    public DiscreteSignal(double amplitude, double frequency, double period) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.period = period;
    }

    // Trả về giá trị biên độ của tín hiệu
    
    public double getAmplitude() {
        return amplitude;
    }

    // Trả về giá trị tần số của tín hiệu
   
    public double getFrequency() {
        return frequency;
    }

    // Trả về giá trị chu kỳ của tín hiệu
    public double getPeriod() {
        return period;
    }

    // Phương thức tính giá trị tín hiệu rời rạc tại một thời điểm n theo công thức f(n) = A * d(n - 4)
    public double calculateSignal(int n) {
        return amplitude * unitImpulse(n - 4);  // Tính toán với giá trị n0 = 4
    }

    // Hàm đơn vị xung d(n): trả về 1 nếu n = 0, ngược lại trả về 0
    private int unitImpulse(int n) {
        return (n == 0) ? 1 : 0;
    }
}

// Lớp ContinuousSignal đại diện cho tín hiệu liên tục, kế thừa giao diện Signal
class ContinuousSignal implements Signal {
    private double amplitude;  // Biên độ của tín hiệu liên tục
    private double frequency;  // Tần số của tín hiệu liên tục
    private double period;     // Chu kỳ của tín hiệu liên tục

    // Constructor để khởi tạo tín hiệu liên tục với các thông số biên độ, tần số và chu kỳ
    public ContinuousSignal(double amplitude, double frequency, double period) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.period = period;
    }

    // Trả về giá trị biên độ của tín hiệu
    public double getAmplitude() {
        return amplitude;
    }

    // Trả về giá trị tần số của tín hiệu

    public double getFrequency() {
        return frequency;
    }

    // Trả về giá trị chu kỳ của tín hiệu
 
    public double getPeriod() {
        return period;
    }

    // Các phương thức khác có thể thêm vào nếu cần cho tín hiệu liên tục
}

// Lớp Radar phân tích tín hiệu dựa trên tín hiệu mẫu rời rạc
class Radar {

    // Phương thức phân tích tín hiệu rời rạc với công thức cho trước: (1 - n/15) nếu 0 <= n <= 15, ngược lại trả về 0
    public double analyzeDiscreteSignal(int n) {
        return (n >= 0 && n <= 15) ? 1 - (double) n / 15 : 0;
    }
}
public class baitapgiuakyoop{
    public static void main(String[] args) {
        // Khởi tạo một tín hiệu rời rạc với biên độ, tần số và chu kỳ
        DiscreteSignal discreteSignal = new DiscreteSignal(10.0, 5.0, 2.0);
        
        // In giá trị tín hiệu rời rạc tại n = 4
        System.out.println("Gia tri tin hieu tai n = 4: " + discreteSignal.calculateSignal(4));

    }
}
