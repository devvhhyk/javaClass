TextField에 텍스트를 입력하고 확인버튼을 누르거나 Enter키를 누르면 TextArea에 입력한 텍스트가 쓰여집니다

텍스트는 쓸 때마다 줄바꿈이 되어 나타납니다

수정을 하고 싶다면 수정버튼을 눌러서 TextArea에 입력이 가능해집니다

한번 더 수정을 누르면 다시 입력이 불가능해집니다

저장버튼을 누르면 입력한 텍스트를 파일로 저장할 수 있으며 종료버튼을 누르면 종료가 됩니다

----

setEnabled() : 비활성화(false) 활성화(true)

setEditable() : 입력불가(false) 입력가능(true)

getDocument() : 텍스트 컴포넌트의 내용에 대한 상태 관리

addDocumentListener() :  텍스트 내용이 변경될 때 이를 감지하는 리스너를 등록하는 메서드

keyListener() : 키를 누를 때마다 특정 동작 수행

keyPressed(KeyEvent d) : 사용자가 키를 누를 때 호출

KeyEvent.VK_ENTER : 엔터키를 눌렀는지 확인

depose() : 창을 닫음

데이터 정보를 다른 클래스로 가져오는 법
1. 생성자의 파라미터로 넘긴다
2. 메서드의 파라미터로 넘긴다

