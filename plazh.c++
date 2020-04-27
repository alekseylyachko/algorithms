#include <iostream>

//  Node is defined as :
typedef struct node
{
    int val;
    struct node* left;
    struct node* right;
    int ht;
} node; 


void find_(int max, int last, node * node) 
{
    last++;
    if (last > max) max = last;

    if (node->right != nullptr) find_(max, last, node->right);
    if (node->left != nullptr) find_(max, last, node->left);
};

int main() {
    int max = 0;
    find_(max,0,nullptr);
	
    std::cout << max << std::endl;
    return 0;
};