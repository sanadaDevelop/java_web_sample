java_web_sample
===============

Javaで作った学習用サンプルアプリケーション

+ 1.指定したユーザ名に該当するユーザに入力した分だけポイントを付与するWebアプリケーションを作成してください
+ 2.ポイントを付与したら、point_historyテーブルに履歴をいれてください。
+ 3.テーブル定義は以下のようになります。

テーブル
--------
### usersテーブル ###
+ id(pk) 
+ name(文字列 ユーザ名)

### pointテーブル ###
+ id(pk)
+ point (数値。付与されたポイントの累計値)
+ user_id (usersテーブルのidと同じ値が入る)

### point_historyテーブル ###
+ id (pk)
+ point(付与したポイント数)
+ user_id（usersテーブルのidと同じ値が入る)
*
+ created_at (付与された日)


