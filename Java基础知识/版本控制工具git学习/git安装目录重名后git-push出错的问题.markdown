### git安装目录重名后git push出错的问题
#### 错误
```$ git push
fatal: unable to access 'https://github.com/ArthurTom/-Notes.git/': error setting certificate verify locations:
CAfile: C:/other/版本控制器/git/Git/mingw64/ssl/certs/ca-bundle.crt
CApath: none
```
#### 原因
由于git安装目录中含有中文，**版本控制**。修改完目录名称后，进行push操作，提示上面的报错。
#### 解决方法
```
$ git config --system http.sslcainfo "C:/other/git/git/Git/mingw64/ssl/certs/ca-bundle.crt"

```
 1. git config --system http.sslcainfo     固定命令
 2. "C:/other/git/git/Git/mingw64/ssl/certs/ca-bundle.crt"  .crt文件的存放的路径
