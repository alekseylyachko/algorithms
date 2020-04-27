#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main() {

    int L;
    int n;

    std::cin >> L;

    std::vector<int> vec(0);

    
    int number = 0;
    int min = 0;

    for (int j = 0; j < L; j++) 
    {
        std::cin >> n;
        vec.clear();
        for (int i = 0; i < n; i++) 
        {
            std::cin >> number;
            vec.push_back(number);
        }
        std::sort(vec.begin(),vec.end());

        int ex = *vec.begin();
        min = (vec[1] ^ vec[0]);

        for (int i = 1; i < vec.size(); i++) 
        {
            if ( ((vec[i] ^ ex) < min) ) {
                min = vec[i]^ex;
            }
            ex = vec[i];
        }


        std::cout << min << std::endl;
    }


	
   
    return 0;
};