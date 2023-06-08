<%@ page import="com.set.model.spec.dto.SpecDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }

        form {
            background-color: #fff;
            padding: 20px;
            width: 400px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-right: 20px;
            height: fit-content;
        }

        label {
            display: inline-block;
            width: 150px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            padding: 10px 20px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="button"] {
            background-color: #f44336;
            margin-left: 10px;
        }

        h1 {
            margin-top: 0;
            margin-bottom: 105px;
        }

        .highlight-red {
            outline: 2px solid red;
        }

        .highlight-green {
            outline: 2px solid green;
        }

        .character-info {
            display: inline;
            align-items: center;
            margin-bottom: 20px;
        }

        .character-info img {
            height: 140px;
            width: 140px;
        }

        .character-info .star {
            height: 32px;
            width: 32px;
        }

        .character-info .element {
            height: 32px;
            width: 32px;
        }

        #specStatus {
            margin-bottom: 20px;
        }

        #specArtifacts {
            margin-bottom: 20px;
        }

        #exSpecStatus {
            margin-bottom: 20px;
        }

        #exSpecArtifacts {
            margin-bottom: 20px;
        }

        #exSpecDiv {
            background-color: #fff;
            padding: 20px;
            width: 400px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            height: fit-content;
        }
    </style>
</head>
<body>
<div style="display: flex">
    <form action="spec/update" method="post">
        <datalist id="ArtifactSands">
            <option value="공격력(%)"/>
            <option value="방어력(%)"/>
            <option value="체력(%)"/>
            <option value="원소 마스터리"/>
            <option value="원소 충전효율(%)"/>
        </datalist>
        <datalist id="ArtifactGoblet">
            <option value="공격력(%)"/>
            <option value="방어력(%)"/>
            <option value="체력(%)"/>
            <option value="원소 마스터리"/>
            <option value="원소 피해(%)"/>
        </datalist>
        <datalist id="ArtifactCirclet">
            <option value="공격력(%)"/>
            <option value="방어력(%)"/>
            <option value="체력(%)"/>
            <option value="원소 마스터리"/>
            <option value="치명타 확률(%)"/>
            <option value="치명타 피해량(%)"/>
        </datalist>
        <div class="character-info">
            <img src="/pic/character/${charInfo[0].charName}.png"/>
            <img class="star" src="/pic/star/star-${charInfo[0].charStar}.png"/>
            <img class="element" src="/pic/element/Element_${charInfo[0].charElement}.png"/>
        </div>
        <div id="specStatus">
            <label>체력</label>
            <input type="text" name="specHp" value="${spec[0].specHp}"><br>
            <label>방어력</label>
            <input type="text" name="specDef" value="${spec[0].specDef}"><br>
            <label>공격력</label>
            <input type="text" name="specAfk" value="${spec[0].specAfk}"><br>
            <label>원소마스터리</label>
            <input type="text" name="specEm" value="${spec[0].specEm}"><br>
            <label>원소충전</label>
            <input type="text" name="specEr" value="${spec[0].specEr}"><br>
            <label>치명타-확률</label>
            <input type="text" name="specCr" value="${spec[0].specCr}"><br>
            <label>치명타-피해</label>
            <input type="text" name="specCdmg" value="${spec[0].specCdmg}"><br>
            <label>기본공격</label>
            <input type="text" name="specSk1" value="${spec[0].specSk1}"><br>
            <label>원소스킬</label>
            <input type="text" name="specSk2" value="${spec[0].specSk2}"><br>
            <label>원소폭발</label>
            <input type="text" name="specSk3" value="${spec[0].specSk3}"><br>
        </div>
        <div id="specArtifacts">
            <label>무기</label>
            <input type="text" name="specWeapon" value="${spec[0].specWeapon}"><br>
            <label>성유물-꽃</label>
            <input type="text" name="specArtifactFlower" value="${spec[0].specArtifactFlower}" readonly><br>
            <label>성유물-깃털</label>
            <input type="text" name="specArtifactPlume" value="${spec[0].specArtifactPlume}" readonly><br>
            <label>성유물-모래시계</label>
            <input type="text" name="specArtifactSands" value="${spec[0].specArtifactSands}" list="ArtifactSands"><br>
            <label>성유물-성배</label>
            <input type="text" name="specArtifactGoblet" value="${spec[0].specArtifactGoblet}" list="ArtifactGoblet"><br>
            <label>성유물-왕관</label>
            <input type="text" name="specArtifactCirclet" value="${spec[0].specArtifactCirclet}" list="ArtifactCirclet"><br>
            <label>기타</label>
            <input type="text" name="specEtc" value="${spec[0].specEtc}"><br>
            <label>기타2</label>
            <input type="text" name="specEtc2"><br>
        </div>
        <div>
            <input type="hidden" name="userId" value="${spec[0].userId}">
            <input type="hidden" name="charNo" value="${spec[0].charNo}">
            <button type="submit">Edit</button>
            <button type="button" onclick="history.back()">Exit</button>
        </div>
    </form>

    <div style="margin-left: 20px;"></div>

    <div id="exSpecDiv">
        <h1>비교스펙표</h1>
        <div id="exSpecStatus">
            <label>체력</label>
            <input type="text" name="specHp" value="${exSpec[0].specHp}" readonly><br>
            <label>방어력</label>
            <input type="text" name="specDef" value="${exSpec[0].specDef}" readonly><br>
            <label>공격력</label>
            <input type="text" name="specAfk" value="${exSpec[0].specAfk}" readonly><br>
            <label>원소마스터리</label>
            <input type="text" name="specEm" value="${exSpec[0].specEm}" readonly><br>
            <label>원소충전</label>
            <input type="text" name="specEr" value="${exSpec[0].specEr}" readonly><br>
            <label>치명타-확률</label>
            <input type="text" name="specCr" value="${exSpec[0].specCr}" readonly><br>
            <label>치명타-피해</label>
            <input type="text" name="specCdmg" value="${exSpec[0].specCdmg}" readonly><br>
            <label>기본공격</label>
            <input type="text" name="specSk1" value="${exSpec[0].specSk1}" readonly><br>
            <label>원소스킬</label>
            <input type="text" name="specSk2" value="${exSpec[0].specSk2}" readonly><br>
            <label>원소폭발</label>
            <input type="text" name="specSk3" value="${exSpec[0].specSk3}" readonly><br>
        </div>
        <div id="exSpecArtifacts">
            <label>무기</label>
            <input type="text" name="specWeapon" value="${exSpec[0].specWeapon}" readonly><br>
            <label>성유물-꽃</label>
            <input type="text" name="specArtifactFlower" value="${exSpec[0].specArtifactFlower}" readonly><br>
            <label>성유물-깃털</label>
            <input type="text" name="specArtifactPlume" value="${exSpec[0].specArtifactPlume}" readonly><br>
            <label>성유물-모래시계</label>
            <input type="text" name="specArtifactSands" value="${exSpec[0].specArtifactSands}" readonly><br>
            <label>성유물-성배</label>
            <input type="text" name="specArtifactGoblet" value="${exSpec[0].specArtifactGoblet}" readonly><br>
            <label>성유물-왕관</label>
            <input type="text" name="specArtifactCirclet" value="${exSpec[0].specArtifactCirclet}" readonly><br>
            <label>기타</label>
            <input type="text" name="specEtc" value="${exSpec[0].specEtc}" readonly><br>
            <label>기타2</label>
            <input type="text" name="specEtc2" value="${exSpec[0].specEtc2}" readonly><br>
        </div>
    </div>
</div>
<script>
    window.addEventListener('DOMContentLoaded', (event) => {
        const specStatusInputs = document.querySelectorAll('#specStatus input');
        const exSpecStatusInputs = document.querySelectorAll('#exSpecStatus input');

        for (let i = 0; i < specStatusInputs.length; i++) {
            const specInput = specStatusInputs[i];
            const exSpecInput = exSpecStatusInputs[i];

            const specValue = parseFloat(specInput.value);
            const exSpecValue = parseFloat(exSpecInput.value);

            if (specValue < exSpecValue) {
                specInput.classList.add('highlight-red');
                exSpecInput.classList.add('highlight-green');
            }
        }
    });
</script>

</body>
</html>
