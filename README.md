# 立法院開放資料服務平台
「會議資訊」、「會議完整影片相關資訊」、「委員發言片段相關影片資訊」、「院會發言名單」、「委員會發言名單」API技術說明文件
## 零、開放資料適用之授權條款
https://data.gov.tw/license
## 壹、程式說明
### 一、JAVA程式命名原則
1.	action
ID+ 流水號 + "Action"。
2.	Obj
ID+ 流水號 + "Obj"。
3.	ObjList
ID+ 流水號 + " ObjList"。
### 二、流水號編碼
會議資訊:42、會議完整影片相關資訊:143、委員發言片段相關影片資訊:148、院會發言名單:221、委員會發言名單:223

## 貳、內容說明
### 一、會議資訊
#### （一）API程式代號：ID42Action
#### （二）資料集類別：會議類
#### （三）欄位名稱
1. term：屆別
2. sessionPeriod：會期
3. sessionTimes：會次
4. meetingTimes：臨時會會次
5. meetingNo：會議編號
6. meetingDateDesc：會議時間區間
7. meetingRoom：會議地點
8. meetingUnit：會議單位
9. jointCommittee：聯席委員會
10.meetingName：會議名稱
11.meetingContent：會議事由
12.coChairman：委員會召集委員
13.attendLegislator：出席委員 
14.selectTerm：屆別期別篩選條件
#### （四）詮釋資料說明：https://data.ly.gov.tw/getds.action?id=42
#### （五）API參數
1. term：屆別
2. sessionPeriod：會期
3. sessionTimes：會次
4. meetingTimes：臨時會會次
5. coChairman：委員會召集委員
6. attendLegislator：出席委員
7. 檔案類型可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID42Action.action?term=10&sessionPeriod=04&sessionTimes=&meetingTimes=&coChairman=&attendLegislator=&fileType=csv
### 二、會議完整影片相關資訊
#### （一）API程式代號：ID143Action
#### （二）資料集類別：會議類
#### （三）欄位名稱：
1. term：屆別
2. sessionPeriod：會期
3. meetingDate：會次
4. meetingDate：會議日期(西元年)
5. meetingTime：會議時間
6. meetingTypeName：主辦單位
7. meetingName：會議名稱
8. meetingContent：會議事由
9. videoUrl：聯席委員會
10.meetingName：會議名稱
11.meetingContent：會議事由
12.videoUrl：影片網址
13.selectTerm：屆別期別篩選條件
#### （四）詮釋資料：https://data.ly.gov.tw/getds.action?id=143
#### （五）API參數
1. term：屆別
2. sessionPeriod：會期
3. sessionTimes：會次
4. meetingDateS：會議起始日期(民國年)
5. meetingDateE：會議結束日期(民國年)
6. 檔案類型可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID143Action.action?term=10&sessionPeriod=4&meetingDateS=110/10/01&meetingDateE=110/10/30&fileType=csv
### 三、委員發言片段相關影片資訊
#### （一）API程式代號：ID148Action
#### （二）資料集類別：會議類
#### （三）欄位名稱：
1. term：屆別
2. sessionPeriod：會期
3. meetingDate：會議日期(西元年)
4. meetingTime：會議時間
6. meetingTypeName：主辦單位
7. meetingName：會議名稱
8. meetingContent：會議事由
9. legislatorName：委員姓名
10.areaName：選區名稱
11.speechStartTime：委員發言時間起
12.speechEndTime：委員發言時間迄
13.speechRecordUrl：發言紀錄網址
14.videoLength：影片長度
15.videoUrl：影片網址
16.selectTerm：屆別期別篩選條件
#### （四）詮釋資料：https://data.ly.gov.tw/getds.action?id=148
#### （五）API參數
1. term：屆別
2. sessionPeriod：會期
3. meetingDateS：會議起始日期(民國年)
4. meetingDateE：會議結束日期(民國年)
6. meetingTime：會議時間
7. legislatorName：委員姓名
8. 檔案類型可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID148Action.action?term=10&sessionPeriod=4&meetingDateS=110/10/01&meetingDateE=110/10/30&meetingTime=&legislatorName=&fileType=csv
### 四、院會發言名單
#### （一）API程式代號：ID221Action
#### （二）資料集類別：會議類
#### （三）欄位名稱：
1. smeetingDate：開會日期(民國年)
2. meetingRoom：會議室
3. meetingTypeName：主辦單位
4. meetingName：會議名稱
5. meetingContent：會議事由
6. speechKindName：發言類別(國是論壇,質詢等等)
7. legislatorNameList：委員發言名單
8.speechType：發言類型(書面,口頭)
#### （四）詮釋資料：https://data.ly.gov.tw/getds.action?id=221
#### （五）API參數
1. meetingDateS：開會起始日期(民國年)
2. meetingDateE：開會結束日期(民國年)
3. meetingRoom：會議室
4. meetingTypeName：主辦單位
5. speechKindName：發言類別(國是論壇,質詢等等)
6. speechType：發言類型(書面,口頭)
7. 檔案類型可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID221Action.action?meetingDateS=110/10/01&meetingDateE=110/10/31&meetingRoom=議場&meetingTypeName=&speechKindName=政黨質詢&speechType=口頭質詢&fileType=csv
### 四、委員會發言名單
#### （一）API程式代號：ID223Action
#### （二）資料集類別：會議類
#### （三）欄位名稱：
1. smeetingDate：開會日期(民國年)
2. meetingRoom：會議室
3. meetingTypeName：主辦單位(全院委員會,內政委員會等等)
4. jointCommittee：聯席委員會(若無聯席委員會,欄位值為"無")
5. meetingName：會議名稱
6. meetingContent：會議事由
7. legislatorNameList：委員發言名單
#### （四）詮釋資料：https://data.ly.gov.tw/getds.action?id=223
#### （五）API參數
1. meetingDateS：開會起始日期(民國年)
2. meetingDateE：開會結束日期(民國年)
3. meetingRoom：會議室
4. meetingTypeName：主辦單位
5. jointCommittee：聯席委員會
6. 檔案類型可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID223Action.action?meetingDateS=110/10/01&meetingDateE=110/10/31&meetingRoom=群賢樓101會議室&meetingTypeName=教育及文化委員會&jointCommittee=&fileType=csv