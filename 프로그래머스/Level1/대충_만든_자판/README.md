# 대충 만든 자판

[문제 페이지](https://school.programmers.co.kr/learn/courses/30/lessons/160586)

## 해결 방법

keymap을 hashMap으로 구현하여 각 알파벳에 맞는 최소값을 구한 후, targets를 돌리면서 해당 Char 값이 있으면 그 값을 더하고 없다면 해당 문자는 만들 수 없으므로 반복문 탈출 후 answer에 -1을 삽입

* HashMap 
* 이중 반복문
