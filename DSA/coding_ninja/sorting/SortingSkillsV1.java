package Sorting;
import java.io.*;
import java.util.*;
public class SortingSkillsV1 {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static boolean checksort(int[] arr, int n)
{
	for (int i = 0; i < n - 1; i++)
	{
		if (arr[i] > arr[i + 1])
		{
			if (arr[i] - arr[i + 1] == 1){
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
			else
				return false;
		}
	}
	return true;
}
public static void main(String[] args) throws IOException {
int t = Integer.parseInt(br.readLine().trim());
while (t != 0){
int n = Integer.parseInt(br.readLine().trim());
int[] arr = new int[n];
StringTokenizer tk = new StringTokenizer(br.readLine().trim());
for (int i = 0; i < n; i++)
{
arr[i] = Integer.parseInt(tk.nextToken());
}
if (checksort(arr, n))
System.out.println("Yes");
else
System.out.println("No");
t--;
}
}
}