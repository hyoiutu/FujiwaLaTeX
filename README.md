# FujiwaLaTeX
自作言語FujiwaLaTeX

TeXコード風にプログラムが書ける言語です．

Qiitaに投稿された
[プログラミング言語を作る。１時間で。](http://qiita.com/shuetsu@github/items/ac21e597265d6bb906dc)
の記事を参考に作りました．

# 準備
* Java8
* JSONIC(JavaでJSONを読む為のパッケージ)

# Hello World
## ソース
``` tex
\begin{fujiwaLaTeX}
\print{"'Hello World!'"};
\end{fujiwaLaTeX}
```

## コンパイラのコンパイル
``` shell
javac -sourcepath "./*" *.javac
```

## コンパイルと実行
``` shell
java Main <ファイル名>
```

# その他のソース
* ex1.ftex
    * 1+2+3の結果を表示するFujiwaLaTeXのソースです．
* ex2.ftex
    * iを入力して0,1,...iの和を表示するFujiwaLaTeXのソースです．

# リファレンス
## step
可変引数を取り取った式を順番に実行します．
``` tex
\step{式1}{式2}...
```
## 標準入出力
### print
文字列や変数の中身を表示します．
``` tex
\print{"'文字列' + 変数 + ..."}
ex) \print{"'Hello World' + variable + '!'"}
```
### input
標準入力です．入力した値を変数に代入します．
``` tex
\input{"変数"}
ex) \input{"i"}
```
## 変数操作
### set
新たに変数を宣言して定義します．
``` tex
\set{"変数"}{値}
ex) \set{"i"}{0}
```
### get
既存の変数の中身を参照します．
``` tex
\get{"変数"}
ex) \get{"i"}
```
## 算術演算
### +
値を加算または減算し，結果を返します．
``` tex
\+{\get{"変数1"}または値}{\get{"変数2"}または値}
ex) \+{\get{"i"}}{\get{"sum"}}, \+{\get{"i"}}{1}, \+{\get{"i"}}{-1}
```
### *
値を乗算し，結果を返します．
``` tex
\*{\get{"変数1"}または値}{\get{"変数2"}または値}
ex) \*{\get{"i"}}{\get{"sum"}}, \*{\get{"i"}}{\get{"i"}}, \*{\get{"i"}}{-1}
```
## 比較演算
### =
2つの値の比較をしてTrueかFalseを返します．
``` tex
\={\get{"変数1"}}または値}{\get{"変数2"}}または値}
ex) \={\get{"i"}}{0}, \={\get{"i"}}{\get{"sum"}}, \={0}{1}
```
## ループ文
### until
条件がTrueの間ループをします．
``` tex
\until{条件文}{ループする内容}
ex) \until{\={"i"}{0}}{
        \step{
            \set{"i"}{
                \+{\get{"i"}}{-1}
            }
        }
    }
```