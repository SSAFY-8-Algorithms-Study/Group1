package Aug3;

import java.util.Scanner;

public class boj2290 {
	static char ans[][];
	static int s, h, w;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.nextInt();
		String n = sc.next();

		h = 2 * s + 3;
		w = s + 3;
		int l = n.length();

		ans = new char[h][l * w];

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				ans[i][j] = ' ';
			}
		}
		for (int i = 0; i < n.length(); i++) {
			char[][] ch;
			switch (n.charAt(i)) {
			case '1':
				ch = lcd(new int[]{2,5});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '2':
				ch = lcd(new int[]{0,2,3,4,6});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}

				break;
			case '3':
				ch = lcd(new int[]{0,2,3,5,6});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '4':
				ch = lcd(new int[]{1,2,3,5});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '5':
				ch = lcd(new int[]{0,1,3,5,6});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '6':
				ch = lcd(new int[]{0,1,3,4,5,6});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '7':
				ch = lcd(new int[]{0,2,5});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '8':
				ch = lcd(new int[]{0,1,2,3,4,5,6});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '9':
				ch = lcd(new int[]{0,1,2,3,5});
				for(int ri=0;ri<h;ri++) {
					for(int cj=0;cj<w;cj++) {
						ans[ri][i*w+cj] = ch[ri][cj];
					}
				}
				break;
			case '0':
				ch = lcd(new int[]{0,1,2,4,5,6});
			for(int ri=0;ri<h;ri++) {
				for(int cj=0;cj<w;cj++) {
					ans[ri][i*w+cj] = ch[ri][cj];
				}
			}
				break;

			default:
				break;
			}
		}
	       for(int i=0; i<ans.length; i++) {
	            for(int j=0; j<ans[0].length; j++) {
	                System.out.print(ans[i][j]);
	            }
	            System.out.println();
	        }

	}

	static char[][] lcd(int[] arr) {
		char[][] lc = new char[h][w];
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 0:
				for (int j = 0; j < s; j++) {
					lc[0][(j + 1)] = '-';
				}
				break;
			case 1:
				for (int j = 0; j < s; j++) {
					lc[j + 1][0] = '|';
				}
				break;
			case 2:
				for (int j = 0; j < s; j++) {
					lc[j + 1][w - 2] = '|';
				}
				break;
			case 3:
				for (int j = 0; j < s; j++) {
					lc[h / 2][(j + 1)] = '-';
				}
				break;
			case 4:
				for (int j = 0; j < s; j++) {
					lc[h / 2 + j + 1][0] = '|';
				}
				break;
			case 5:
				for (int j = 0; j < s; j++) {
					lc[h / 2 + j + 1][w - 2] = '|';
				}
				break;
			case 6:
				for (int j = 0; j < s; j++) {
					lc[h - 1][(j+1)] = '-';
				}
				break;

			default:
				break;
			}
		}
		return lc;

	}
}
