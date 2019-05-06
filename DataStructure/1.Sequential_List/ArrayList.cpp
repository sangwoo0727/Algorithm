#include <stdio.h>
#include "ArrayList.h"


void ListInit(List *plist) {  // 리스트 초기화
	(plist->numOfData) = 0;
	(plist->curPosition) = -1;
}

void LInsert(List * plist, LData data) { // 리스트에 데이터 삽입
	if (plist->numOfData >= LIST_LEN) {
		printf("저장이 불가능합니다\n");
		return;
	}
	plist->arr[plist->numOfData] = data;
	(plist->numOfData)++;
}

int LFirst(List * plist, LData * pdata) { //
	if (plist->numOfData == 0) return FALSE;
	(plist->curPosition) = 0;
	*pdata = plist->arr[0];
	return TRUE;
}

int LNext(List * plist, LData * pdata) {
	if (plist->curPosition >= (plist->numOfData) - 1) return FALSE;
	(plist->curPosition)++;
	*pdata = plist->arr[plist->curPosition];
	return TRUE;
}

LData LRemove(List*plist) {
	int rpos = plist->curPosition;
	int num = plist->numOfData;
	LData rdata = plist->arr[rpos];

	for (int i = rpos; i < num - 1; i++) {
		plist->arr[i] = plist->arr[i + 1];
	}

	(plist->numOfData)--;
	(plist->curPosition)--;
	return rdata;
	
}

int LCount(List * plist) {
	return plist->numOfData;
}