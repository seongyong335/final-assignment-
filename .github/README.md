<div align="center">
  <a href="https://github.com/seongyon335/final-assignment-master"><img src="https://capsule-render.vercel.app/api?type=waving&height=200&section=header&text=GENSHIN-SET&fontAlign=70&fontAlignY=40&color=gradient"/> 
</div>
<div>
  <pre>
  본 프로젝트는 게임 '원신'의 캐릭터를 얼마나 잘 키웠는지 본인의 캐릭터 스펙을 관리하고 점검할 수 있는 웹 사이트입니다.
  사용자는 본인의 계정을 이용하여 본인의 캐릭터의 스펙을 기입하여 관리할 수 있고 해당 캐릭터의 스펙이 잘 키웠는지 못 키웠는지 점검할 수 있습니다.</pre>
</div>
<br>
<div>
	<h1>이용방법</h1>
  <pre>
  1. 계정을 생성합니다.
  2. 로그인 합니다.
  3. 캐릭터 추가를 눌러 본인이 가지고 있는 캐릭터의 초상화를 클릭합니다.
  4. 캐릭터의 스펙을 입력합니다.
  5. 메인화면에서 본인 캐릭터의 초상화를 누르면 오른쪽에 추천하는 세팅값이 나옵니다.
  6. 만약 본인이 부족한 부분이 존재한다면 해당 항목이 빨간색으로 불이 들어옵니다.
  7. 본인 스펙의 수치를 수정하고 하단의 수정 버튼을 눌러 언제든지 값을 변경할 수 있습니다.
  8. 메인화면의 회원 정보를 눌러 회원의 정보 수정이 가능합니다.
  9. 바꿀 비밀번호를 입력하고 회원 수정을 누르면 비밀번호가 변경이 됩니다.
  10. 회원 탈퇴를 누르면 회원 정보가 삭제 됩니다.</pre>

	
	<h3>스펙 예시가 존재하는 캐릭터 목록</h3>
	
	<h3>스펙 입력 예시</h3>
<img width="396" alt="스크린샷 2023-06-09 10 49 34" src="https://github.com/seongyong335/final-assignment-master/assets/127364188/bf25a55f-669c-4396-b22d-bc0291c69f8e">
	<h3>스펙 입력 후 확인 화면</h3>
<img width="837" alt="스크린샷 2023-06-09 10 49 55" src="https://github.com/seongyong335/final-assignment-master/assets/127364188/b13ede6b-206c-4a27-8135-6ad24381f7ab">
	<h3>부족한 스펙 표시 화면</h3>
<img width="837" alt="스크린샷 2023-06-09 10 50 13" src="https://github.com/seongyong335/final-assignment-master/assets/127364188/8e26268a-7bec-446e-bd8b-10d6191018f6">

	
</div>
<br>
<div>
	<h1>DB</h1>
  <pre>
create database genshinsetdb;

show databases;

grant all privileges on genshinsetdb.* to sahmyook@'%';

show grants for sahmyook@'%';
<br>
 <pre>
  USE genshinsetdb;

CREATE TABLE `CHARACTER` (
	`CHAR_NO`	MEDIUMINT	NOT NULL	COMMENT '캐릭터번호',
	`CHAR_NAME`	VARCHAR(50)	NOT NULL	COMMENT '캐릭터 이름',
	`CHAR_ELEMENT`	VARCHAR(8)	NOT NULL	COMMENT '캐릭터 원소속성',
	`CHAR_STAR`	MEDIUMINT NOT NULL	COMMENT '캐릭터 별 갯수'
);

CREATE TABLE `USER_INFO` (
	`USER_ID`	VARCHAR(50)	NOT NULL	COMMENT '회원 아이디',
	`USER_PASSWORD`	VARCHAR(50)	NOT NULL	COMMENT '회원 비밀번호'
);

CREATE TABLE `SPEC` (
	`CHAR_NO`	MEDIUMINT	NOT NULL	COMMENT '캐릭터번호',
	`USER_ID`	VARCHAR(50)	NOT NULL	COMMENT '회원 아이디',
	`SPEC_SK_1`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 기본공격',
	`SPEC_SK_2`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 원소스킬',
	`SPEC_SK_3`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 원소폭발',
	`SPEC_WEAPON`	VARCHAR(50)	NULL	COMMENT '스펙 무기',
	`SPEC_ARTIFACT_FLOWER`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 꽃',
	`SPEC_ARTIFACT_PLUME`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 깃털',
	`SPEC_ARTIFACT_SANDS`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 모래시계',
	`SPEC_ARTIFACT_GOBLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 성배',
	`SPEC_ARTIFACT_CIRCLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 왕관',
	`SPEC_HP`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 체력',
	`SPEC_DEF`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 방어력',
	`SPEC_AFK`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 공격력',
	`SPEC_EM`	MEDIUMINT	NOT NULL	DEFAULT 0	DEFAULT 0	COMMENT '스펙 원소마스터리',
	`SPEC_ER`	DOUBLE		NOT NULL	DEFAULT 000.0	COMMENT '스펙 원소충전',
	`SPEC_CR`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타확률',
	`SPEC_CDMG`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타피해',
	`SPEC_ETC`	VARCHAR(100)	NULL	COMMENT '스펙 기타',
	`SPEC_ETC_2`	VARCHAR(100)	NULL	COMMENT '스펙 기타2'
    );

CREATE TABLE `SPEC_EX` (
	`SPEC_NO`	MEDIUMINT	NOT NULL AUTO_INCREMENT	COMMENT '스펙 번호',
	`CHAR_NO`	MEDIUMINT	NOT NULL	COMMENT '캐릭터번호',
	`SPEC_SK_1`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 기본공격',
	`SPEC_SK_2`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 원소스킬',
	`SPEC_SK_3`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 원소폭발',
	`SPEC_WEAPON`	VARCHAR(50)	NULL	COMMENT '스펙 무기',
	`SPEC_ARTIFACT_FLOWER`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 꽃',
	`SPEC_ARTIFACT_PLUME`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 깃털',
	`SPEC_ARTIFACT_SANDS`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 모래시계',
	`SPEC_ARTIFACT_GOBLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 성배',
	`SPEC_ARTIFACT_CIRCLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 왕관',
	`SPEC_HP`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 체력',
	`SPEC_DEF`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 방어력',
	`SPEC_AFK`	MEDIUMINT	NOT NULL	DEFAULT 0	COMMENT '스펙 공격력',
	`SPEC_EM`	MEDIUMINT	NOT NULL	DEFAULT 0	DEFAULT 0	COMMENT '스펙 원소마스터리',
	`SPEC_ER`	DOUBLE		NOT NULL	DEFAULT 000.0	COMMENT '스펙 원소충전',
	`SPEC_CR`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타확률',
	`SPEC_CDMG`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타피해',
	`SPEC_ETC`	VARCHAR(100)	NULL	COMMENT '스펙 기타',
	`SPEC_ETC_2`	VARCHAR(100)	NULL	COMMENT '스펙 기타2',
	PRIMARY KEY (SPEC_NO, CHAR_NO)
);

ALTER TABLE `CHARACTER` ADD CONSTRAINT `PK_CHARACTER` PRIMARY KEY (
	`CHAR_NO`
);

ALTER TABLE `USER_INFO` ADD CONSTRAINT `PK_USER_INFO` PRIMARY KEY (
	`USER_ID`
);

ALTER TABLE `SPEC` ADD CONSTRAINT `PK_SPEC` PRIMARY KEY (
	`CHAR_NO`,
	`USER_ID`
);


ALTER TABLE `SPEC` ADD CONSTRAINT `FK_CHARACTER_TO_SPEC_1` FOREIGN KEY (
	`CHAR_NO`
)
REFERENCES `CHARACTER` (
	`CHAR_NO`
);

ALTER TABLE `SPEC` ADD CONSTRAINT `FK_USER_INFO_TO_SPEC_1` FOREIGN KEY (
	`USER_ID`
)
REFERENCES `USER_INFO` (
	`USER_ID`
);

ALTER TABLE `SPEC_EX` ADD CONSTRAINT `FK_CHARACTER_TO_SPEC_EX_1` FOREIGN KEY (
	`CHAR_NO`
)
REFERENCES `CHARACTER` (
	`CHAR_NO`
);

commit;

 </pre>
<pre>
USE genshinsetdb;

INSERT INTO genshinsetdb.CHARACTER (CHAR_NO, CHAR_NAME, CHAR_ELEMENT, CHAR_STAR) VALUES
(1, 'Traveler', 'Anemo', 5),
(2, 'Venti', 'Anemo', 5),
(3, 'Jean', 'Anemo', 5),
(4, 'Xiao', 'Anemo', 5),
(5, 'Kazuha', 'Anemo', 5),
(6, 'Wanderer', 'Anemo', 5),
(7, 'Sucrose', 'Anemo', 4),
(8, 'Heizou', 'Anemo', 4),
(9, 'Sayu', 'Anemo', 4),
(10, 'Faruzan', 'Anemo', 4),
(11, 'Aloy', 'Cryo', 5),
(12, 'Qiqi', 'Cryo', 5),
(13, 'Ganyu', 'Cryo', 5),
(14, 'Shenhe', 'Cryo', 5),
(15, 'Ayaka', 'Cryo', 5),
(16, 'Eula', 'Cryo', 5),
(17, 'Kaeya', 'Cryo', 4),
(18, 'Diona', 'Cryo', 4),
(19, 'Rosaria', 'Cryo', 4),
(20, 'Chongyun', 'Cryo', 4),
(21, 'Layla', 'Cryo', 4),
(22, 'Mika', 'Cryo', 4),
(23, 'Traveler', 'Electro', 5),
(24, 'Keqing', 'Electro', 5),
(25, 'Raiden', 'Electro', 5),
(26, 'Yae Miko', 'Electro', 5),
(27, 'Cyno', 'Electro', 5),
(28, 'Lisa', 'Electro', 4),
(29, 'Razor', 'Electro', 4),
(30, 'Fischl', 'Electro', 4),
(31, 'Beidou', 'Electro', 4),
(32, 'Sara', 'Electro', 4),
(33, 'Kuki Shinobu', 'Electro', 4),
(34, 'Dori', 'Electro', 4),
(35, 'Traveler', 'Dendro', 5),
(36, 'Tighnari', 'Dendro', 5),
(37, 'Nahida', 'Dendro', 5),
(38, 'Alhaitham', 'Dendro', 5),
(39, 'Baizhu', 'Dendro', 5),
(40, 'Collei', 'Dendro', 4),
(41, 'Yaoyao', 'Dendro', 4),
(42, 'Kaveh', 'Dendro', 4),
(43, 'Traveler', 'Geo', 5),
(44, 'Zhongli', 'Geo', 5),
(45, 'Albedo', 'Geo', 5),
(46, 'Itto', 'Geo', 5),
(47, 'Noelle', 'Geo', 4),
(48, 'Ningguang', 'Geo', 4),
(49, 'Yun Jin', 'Geo', 4),
(50, 'Gorou', 'Geo', 4),
(51, 'Mona', 'Hydro', 5),
(52, 'Childe', 'Hydro', 5),
(53, 'Ayato', 'Hydro', 5),
(54, 'Kokomi', 'Hydro', 5),
(55, 'Yelan', 'Hydro', 5),
(56, 'Nilou', 'Hydro', 5),
(57, 'Barbara', 'Hydro', 4),
(58, 'Xingqiu', 'Hydro', 4),
(59, 'Candace', 'Hydro', 4),
(60, 'Diluc', 'Pyro', 5),
(61, 'Klee', 'Pyro', 5),
(62, 'Hu Tao', 'Pyro', 5),
(63, 'Yoimiya', 'Pyro', 5),
(64, 'Dehya', 'Pyro', 5),
(65, 'Amber', 'Pyro', 4),
(66, 'Bennett', 'Pyro', 4),
(67, 'Xiangling', 'Pyro', 4),
(68, 'Xinyan', 'Pyro', 4),
(69, 'Yanfei', 'Pyro', 4),
(70, 'Thoma', 'Pyro', 4);

commit;
</pre>

<pre>
USE genshinsetdb;

INSERT INTO SPEC_EX (SPEC_NO, CHAR_NO, 
SPEC_SK_1, SPEC_SK_2, SPEC_SK_3, SPEC_WEAPON, 
SPEC_ARTIFACT_FLOWER, SPEC_ARTIFACT_PLUME, SPEC_ARTIFACT_SANDS, SPEC_ARTIFACT_GOBLET, SPEC_ARTIFACT_CIRCLET,
SPEC_HP, SPEC_DEF, SPEC_AFK, SPEC_EM, SPEC_ER, SPEC_CR, SPEC_CDMG, SPEC_ETC, SPEC_ETC_2)
VALUES
(1, 1, 
1, 8, 8, "크시포스의 달빛", 
"체력", "공격력", "원소 마스터리", "원소 마스터리", "원소 마스터리",
0, 0, 0, 750, 220, 0, 0, "청록4", ""),

(1, 2, 
1, 10, 10, "종말 탄식의 노래", 
"체력", "공격력", "원소 마스터리", "원소 마스터리", "원소 마스터리",
0, 0, 0, 650, 180, 0, 0, "청록4", "원마 800까지 추천"),

(1, 3, 
1, 10, 10, "매의 검", 
"체력", "공격력", "공격력%", "원소피해(%)", "치확/치피",
0, 0, 1000, 180, 0, 60, 120, "청록4, 왕실4", "치명무기 - 70/150"),

(1, 5, 
1, 10, 10, "크시포스의 달빛", 
"체력", "공격력", "원소 마스터리", "원소 마스터리", "원소 마스터리",
0, 0, 0, 900, 120, 0, 0, "청록4", "원충 불편하면 140+"),

(1, 6, 
10, 10, 10, "툴레이툴라의 기억", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 2100, 0, 0, 80, 170, "누각4", "치명무기X - 70/140"),

(1, 13, 
10, 8, 10, "파마궁", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 1900, 0, 0, 60, 160, "악단4, 융해감우세팅", "치명무기 - 60/210"),

(1, 14, 
1, 10, 10, "파도 베는 지느러미", 
"체력", "공격력", "공격력(%)", "공격력(%)", "공격력(%)",
0, 0, 3000, 0, 210, 0, 0, "왕실4, 원충시계가능", "페보창 - 치확 35+ 원충 조금 낮게"),

(1, 15, 
10, 10, 10, "안개를 가르는 회광", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 2300, 0, 120, 40, 250, "얼음4, 빙결팟", "치명무기X - 30/220"),

(1, 16, 
10, 10, 10, "송뢰가 울릴 무렵", 
"체력", "공격력", "공격력(%)", “물리피해(%)", "치확/치피",
0, 0, 2400, 0, 120, 60, 160, "창백4, 유라이덴X - 원충 170", "치명무기 - 70/180"),

(1, 21, 
1, 10, 8, "페보니우스 검", 
"체력", "공격력", "체력(%)", "체력(%)", "체력(%)",
41000, 0, 0, 0, 100, 0, 0, "천암4", "성현 - 체력 51000"),

(1, 24, 
10, 10, 10, "안개를 가르는 회광", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 2400, 0, 0, 65, 200, "번분4, 뇌명4", "치명무기X - 65/150"),

(1, 25, 
1, 10, 10, "예초의 번개", 
"체력", "공격력", "원소 충전(%)", "원소피해(%)", "치확/치피",
0, 0, 2000, 0, 270, 60, 120, "절연4, 공퍼성배 공2300", "치명무기 - 70/150"),

(1, 26, 
1, 10, 10, "카구라의 진의", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 2000, 0, 130, 80, 185, "도금4, 번분4", "원충 180까지 부족한만큼"),

(1, 30, 
1, 10, 1, "절현", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 1700, 0, 120, 60, 120, "공(%)2+2, 격화기준", "치명무기 - 70/150"),

(1, 33, 
1, 10, 1, "크시포스의 달빛", 
"체력", "공격력", "원소 마스터리", "원소 마스터리", "원소 마스터리",
24000, 0, 0, 900, 0, 0, 0, "도금4, 숲기억4", "만개요원은 낙원4"),

(1, 35, 
1, 8, 8, "페보니우스 검", 
"체력", "공격력", "원소 충전(%)", "원소 마스터리", "원소 마스터리",
0, 0, 0, 550, 200, 0, 0, "숲기억4", ""),

(1, 36, 
10, 10, 10, "절현", 
"체력", "공격력", "원소 마스터리", "원소피해(%)", "치확/치피",
0, 0, 1000, 0, 200, 60, 120, "숲기억4, 악단4", "치명무기 - 70/150"),

(1, 37, 
1, 10, 10, "떠오르는 천일 밤의 꿈", 
"체력", "공격력", "원소 마스터리", "원소 마스터리", "원소 마스터리",
0, 0, 0, 1000, 130, 35, 120, "숲기억4, 도금4", "치피/치확뚝 가능"),

(1, 38, 
10, 10, 10, "잎을 가르는 빛", 
"체력", "공격력", "원소 마스터리", "원소피해(%)", "치확/치피",
0, 0, 1400, 300, 130, 70, 200, "도금4, 원마2+2", "칠흑검 - 치피 150"),

(1, 41, 
1, 10, 10, "키타인 십자창", 
"체력", "공격력", "원소 마스터리", "원소 마스터리", "원소 마스터리",
30000, 0, 0, 700, 150, 0, 0, "숲기억4, 2돌 기준", "명함은 원충 200"),

(1, 44, 
1, 10, 10, "흑술창", 
"체력", "공격력", "체력(%)", "체력(%)", "체력(%)",
55000, 0, 0, 0, 0, 0, 0, "천암4", ""),

(1, 51, 
1, 1, 10, "드래곤 슬레이어 영웅담", 
"체력", "공격력", "원소 충전(%)", "원소피해(%)", "치확/치피",
0, 0, 1100, 0, 180, 60, 120, "왕실4, 절연4", ""),

(1, 53, 
1, 10, 10, "하란 월백의 후츠", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 2100, 0, 130, 80, 200, "제사4, 몰락4, 검투4", "치명무기X - 70/150"),

(1, 54, 
10, 10, 10, "불멸의 달빛", 
"체력", "공격력", "체력(%)", "원소피해(%)", "치유 보너스",
38000, 0, 0, 0, 150, 0, 0, "조개4, 개회는 체퍼성배", "원충 200까지 부족한 만큼"),

(1, 55, 
1, 10, 10, "약수", 
"체력", "공격력", "체력(%)", "원소피해(%)", "치확/치피",
26000, 0, 0, 0, 200, 80, 200, "절연4", "치명무기X - 70/140"),

(1, 56, 
1, 10, 10, "성현의 열쇠", 
"체력", "공격력", "체력(%)", "체력(%)", "체력(%)",
73000, 0, 0, 0, 130, 0, 0, "천암2 + 감로2, 물공명 기준", "성현 없으면 체력 60000"),

(1, 57, 
1, 10, 10, "제례의 악장", 
"체력", "공격력", "체력(%)", "체력(%)", "치유 보너스",
33000, 0, 0, 300, 0, 0, 0, "도금2+악단2, 원마 650까지", "시계 성배 원마랑 교체 가능"),

(1, 58, 
1, 10, 10, "제례검", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 1300, 0, 160, 60, 120, "절연4, 원충시계 가능", "원충 부족하면 180+"),

(1, 62, 
10, 10, 10, "호마의 지팡이", 
"체력", "공격력", "체력(%)", "불원피", "치확/치피",
35000, 0, 3500, 200, 0, 70, 200, "마녀4, 시메4", "치명무기X - 70/140")

(1, 63, 
10, 10, 8, "비뢰의 고동", 
"체력", "공격력", "공격력(%)", "원소피해(%)", "치확/치피",
0, 0, 2400, 0, 115, 70, 190, "시메4, 원충 150까지", "치명무기X - 70/140"),

(1, 64, 
1, 10, 10, "갈대 바다의 등대", 
"체력", "공격력", "체력(%)", "체력(%)", "체력(%)",
58000, 0, 0, 0, 0, 0, 0, "천암2 + 감로2", "탱서폿 기준"),

(1, 66, 
1, 1, 10, "원목 검", 
"체력", "공격력", "원소 충전(%)", "체력(%)", "치유 보너스",
25000, 0, 0, 0, 250, 0, 0, "왕실4", ""),

(1, 67, 
1, 10, 10, "어획", 
"체력", "공격력", "원소 충전(%)", "원소피해(%)", "치확/치피",
0, 0, 1200, 0, 250, 60, 120, "절연4, 배터리 있으면 원마시계", "배터리 있으면 원마 300+ 원충 낮추기");

commit;
</pre>
</div>
