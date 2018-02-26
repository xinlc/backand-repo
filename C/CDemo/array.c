#include <stdio.h>
#define ROWS 3
#define COLS 4

// void sum2d(int ar[][COLS], int rows);
// int sum2d(int(*ar)[COLS], int rows);

int sum2d(int (*ar)[COLS], int rows) {
  int r;
  int c;
  int tot = 0;
  for(int r = 0; r < rows; r++)
  {
    for(int c = 0; c < COLS; c++)
    {
      tot += ar[r][c];
    }
  }
  return tot;
  
}
int main(int argc, char const *argv[])
{
  int junk[ROWS][COLS] = { {2,4,5,8}, {3,5,6,9}, {12,10,8,6} };
  // int arr1[4] = {6,7,8,9};
  int * arr1 = (int [2]){1,2};

  arr1[0] = 2;
  // int * i = &arr1;

  printf("sum of all elements = %d\n", arr1[0]);
  printf("sum of all elements = %d\n", *(arr1 + 2));
  printf("sum of all elements = %d\n",sum2d(junk, ROWS));
  return 0;
}

