#include <stdio.h>
#include <string.h>
#define PRAISE "you are an extraordnary being."

int main(void) {
  char name[40];
  printf("waht's your name?");
  scanf("%s", name);
  printf("Hello, %s. %s\n", name, PRAISE);
  printf("aaa, %lu\n", sizeof name);
  printf("aaa, %zd", strlen(name));
  return 0;
}