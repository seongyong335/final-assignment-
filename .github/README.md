<div align="center">
  <a href="https://github.com/seongyon335/final-assignment-master"><img src="https://capsule-render.vercel.app/api?type=waving&height=200&section=header&text=GENSHIN-SET&fontAlign=70&fontAlignY=40&color=gradient"/> 
</div>
<div>
  <pre>
  본 프로젝트는 게임 '원신'의 캐릭터를 얼마나 잘 키웠는지 본인의 캐릭터 스펙을 관리하고 점검할 수 있는 웹 사이트를 제작하는 프로젝트입니다.
  사용자는 본인의 계정을 이용하여 본인의 캐릭터의 스펙을 기입하여 관리할 수 있고 해당 캐릭터의 스펙이 잘 키웠는지 못 키웠는지 점검할 수 있습니다.</pre>
</div>
<br>
<div>
	<h1>DB</h1>
  <pre>
  create database genshinsetdb;
  
  show databases;
  
  grant all privileges on genshinsetdb.* to sahmyook@'%';
  
  show grants for sahmyook@'%';</pre>
<br>
 <pre>
  USE genshinsetdb;

CREATE TABLE `CHARACTER` (
	`CHAR_NO`	MEDIUMINT	NOT NULL	COMMENT '캐릭터번호',
	`CHAR_NAME`	VARCHAR(50)	NOT NULL	COMMENT '캐릭터 이름',
	`CHAR_ELEMENT`	VARCHAR(8)	NOT NULL	COMMENT '캐릭터 원소속성'
);

CREATE TABLE `USER_INFO` (
	`USER_ID`	VARCHAR(50)	NOT NULL	COMMENT '회원 아이디',
	`USER_PASSWORD`	VARCHAR(50)	NOT NULL	COMMENT '회원 비밀번호'
);

CREATE TABLE `SPEC` (
	`CHAR_NO`	MEDIUMINT	NOT NULL	COMMENT '캐릭터번호',
	`USER_ID`	VARCHAR(50)	NOT NULL	COMMENT '회원 아이디',
	`SPEC_SK_1`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 기본공격',
	`SPEC_SK_2`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 원소스킬',
	`SPEC_SK_3`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 원소폭발',
	`SPEC_WEAPON`	VARCHAR(50)	NULL	COMMENT '스펙 무기',
	`SPEC_ARTIFACT_FLOWER`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 꽃',
	`SPEC_ARTIFACT_PLUME`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 깃털',
	`SPEC_ARTIFACT_SANDS`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 모래시계',
	`SPEC_ARTIFACT_GOBLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 성배',
	`SPEC_ARTIFACT_CIRCLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 왕관',
	`SPEC_HP`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 체력',
	`SPEC_DEF`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 방어력',
	`SPEC_AFK`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 공격력',
	`SPEC_EM`	MEDIUMINT	NOT NULL	DEFAULT 1	DEFAULT 0	COMMENT '스펙 원소마스터리',
	`SPEC_ER`	DOUBLE		NOT NULL	DEFAULT 100.0	COMMENT '스펙 원소충전',
	`SPEC_CR`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타확률',
	`SPEC_CDMG`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타피해',
	`SPEC_DMG_BONUS`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 속성피해',
	`SPEC_ETC`	VARCHAR(100)	NULL	COMMENT '스펙 기타'
);

CREATE TABLE `SPEC_EX` (
	`SPEC_NO`	MEDIUMINT	NOT NULL AUTO_INCREMENT	COMMENT '스펙 번호',
	`CHAR_NO`	MEDIUMINT	NOT NULL	COMMENT '캐릭터번호',
	`SPEC_SK_1`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 기본공격',
	`SPEC_SK_2`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 원소스킬',
	`SPEC_SK_3`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 원소폭발',
	`SPEC_WEAPON`	VARCHAR(50)	NULL	COMMENT '스펙 무기',
	`SPEC_ARTIFACT_FLOWER`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 꽃',
	`SPEC_ARTIFACT_PLUME`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 깃털',
	`SPEC_ARTIFACT_SANDS`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 모래시계',
	`SPEC_ARTIFACT_GOBLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 성배',
	`SPEC_ARTIFACT_CIRCLET`	VARCHAR(50)	NULL	COMMENT '스펙 성유물 왕관',
	`SPEC_HP`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 체력',
	`SPEC_DEF`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 방어력',
	`SPEC_AFK`	MEDIUMINT	NOT NULL	DEFAULT 1	COMMENT '스펙 공격력',
	`SPEC_EM`	MEDIUMINT	NOT NULL	DEFAULT 1	DEFAULT 0	COMMENT '스펙 원소마스터리',
	`SPEC_ER`	DOUBLE		NOT NULL	DEFAULT 100.0	COMMENT '스펙 원소충전',
	`SPEC_CR`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타확률',
	`SPEC_CDMG`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 치명타피해',
	`SPEC_DMG_BONUS`	DOUBLE		NOT NULL	DEFAULT 0	COMMENT '스펙 속성피해',
	`SPEC_ETC`	VARCHAR(100)	NULL	COMMENT '스펙 기타',
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

commit;</pre>
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

commit
</pre>
</div>
