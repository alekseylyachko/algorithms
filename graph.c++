#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main() {

    int n;
    int m;

    std::cin >> n;
    std::cin >> m;

    int arr[n][n];
    
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) arr[i][j] = 0;

    int a, b, c;

    for (int j = 0; j < m; j++) 
    {
        std::cin >> a;
        std::cin >> b;
        std::cin >> c;

        if ( (arr[a-1][b-1] > c) || (arr[a-1][b-1] == 0) )
        {
            arr[a-1][b-1] = c;
            arr[b-1][a-1] = c;
        }
    }
    
    std::cout << std::endl;

    int max = 0;
    int temp = 0;

    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n; j++)
        {
            if ( (arr[i][j] != 0) && (temp < arr[i][j]) ) {
                temp = arr[i][j];
            }
            // std::cout << arr[i][j] << " ";
        }
        if (temp > max) max = temp;
        // std::cout << std::endl;
    }

    std::cout << max << std::endl;
	
   
    return 0;
};