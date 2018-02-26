#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
  const int SLEN = 40;
  const int LIM = 5;
  const char *mytalents[LIM] = {
    "aaaafffd",
    "1aaaafffd",
    "2aaaafffd",
  };

  const char yourtalents[LIM][SLEN] = {
    "aaaafffd",
    "1aaaafffd",
    "2aaaafffd",
  };
  
  printf("%s \n", *(mytalents +1));
  printf("%s \n", yourtalents[1]);


  char str1 [] = "asdfas";
  puts(str1);

  int i,times;

  if(argc < 2 || (times = atoi(argv[1])) < 1){
    printf("usage: %s positive-number\n", argv[0]);
  } else {
    for(int i = 0; i < times; i++)
    {
      puts("Hello, good looking!");
    }
  }
  
  return 0;
}
