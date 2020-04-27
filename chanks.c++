#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


bool ok(int arr[], int from, int b1, int b2)
{
    for (int i = b1-1; i < b2; i++) {
        if (arr[i] != from) return false;
    };
    return true;
}

void move(int arr[], int to, int b1, int b2)
{
    for (int i = b1-1; i < b2; i++) {
        arr[i] = to;
    };
}

int main() {

    int n;
    int m;
    int q;

    std::cin >> n;
    std::cin >> m;
    std::cin >> q;

    int state[n];
    
    int from, to, b1, b2;


    for (int j = 0; j < n; j++) 
    {
        std::cin >> state[j];
    }

    for (int i = 0; i < q; i++) {
        
        std::cin >> from;
        std::cin >> to;
        std::cin >> b1;
        std::cin >> b2;
        
        
        
        if (ok(state,from,b1,b2)) 
        {
            move(state,to,b1,b2);
            std::cout<<1<<std::endl;
        } else {
            std::cout<<0<<std::endl;
        }

    }
   
    return 0;
};