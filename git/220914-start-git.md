## git/github 

git bash로 들어가서 관리자 권한으로 파일을 실행
첫화면에 ~$ 표시 - /$로 뜰수도있으나 cd를 입력하면 ~$로 돌아옮

mkdir - 새 디렉토리를 만듦
touch - 새 파일을 만듦
mv - 이동시키기
cp - 복사

.. - 상위파일로
. - 하위파일

<지우는 명령어>
 delete - object를 완전히 지운다
 remove - 그 파일에 접근할 수 있는 방법을 지운다(파일이 남아있음)

 * - 에스터리스트 -> 와일드 카드/ 조건과 일치하는 모든/ 디렉토리는 안지워짐/그냥 지우면 파일이 길을 잃음 - ex) rm -r src 이런식으로 옵션을 달아야 한다.

글을 쓸 때 -> tap <자동완성 기능>

vim mode - normal 모드가 기준
I - 인서트 
:WQ - 저장 후 나가기(esc 누른후 노멀모드에서 나갈수 있음)
cat -  취합하여 쉘에 던짐


back quote - 인용표현/ 하이라이트
 
- github에 파일 올리기

add - commit - push 순으로

> ☆ 파일 올리기 예시
> 1. touch test.txt
> 2. vi test.txt
> 3. git status(확인)
> 4. git add test.txt
> 5. git status
> 6. git commit 
> 7. git push(-파일이 한개 이상일 경우 - git puch origin main)


