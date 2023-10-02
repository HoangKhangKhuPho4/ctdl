package task1;

public class TowersOfHanoi {
	public static void moveTower(int disk, char source, char dest, char spare) {
		if (disk == 0) {
			System.out.println("Move disk from " + source + " to " + dest);
		} else {
			moveTower(disk - 1, source, spare, dest); // Move n-1 disks from source to spare using dest as spare
			System.out.println("Move disk from " + source + " to " + dest); // Move nth disk from source to dest
			moveTower(disk - 1, spare, dest, source); // Move n-1 disks from spare to dest using source as spare
		}
	}

	public static void main(String[] args) {
		int n = 3; // Let's test with 3 disks
		moveTower(n, 'A', 'C', 'B'); // Move 3 disks from rod A to rod C using rod B as spare
	}
}
