#include <stdio.h>

unsigned long Fibonacci(unsigned n);
int main(void){

  printf("%s", "start...\n");
  unsigned long aa = Fibonacci(10);
  printf("%lu \n", aa);
}

unsigned long Fibonacci(unsigned n){
  if(n > 2){
    unsigned long a = Fibonacci(n-1) + Fibonacci(n-2);
    printf("%lu \n", a);
    return a;
  }else{
    return 1;
  }
}