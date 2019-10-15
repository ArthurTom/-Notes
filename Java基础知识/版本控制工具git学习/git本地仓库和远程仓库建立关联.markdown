# Git 常用操作 --本地仓库和远程仓库gitHub的关联
### 本地仓库创建
1. 新建文件夹
2. ``` git init  // 初始化本地仓库 ```
3. ```git add .   // 将本地文件加入到仓库缓存中 ```
4. ```git commit -m "提交信息" // 将缓存中的数据提交到本地仓库中默认的master分支中 ```
###  本地仓库链远程仓库
``` git remote add origin https://github.com/arthurTom/-Notes.git ```
其中origin：默认远程仓库的名称,地址是: https://github.com/arthurTom/-Notes.git.
### 本地仓库远程分支信息提交到远程仓库
``` git push -u origin master```  // 将本地仓库信息提交到远程仓库master分支上

<font color=red>*注意:* </font>
    如果第一次提交就```git push ``` 会出现以下的错误:

       fatal: The current branch master has no upstream branch.
       To push the current branch and set the remote as upstream, use
       git push --set-upstream origin master
  由于远程库是空的，我们第一次推送master分支时，加上了-u参数，Git不但会把本地的master分支内容推送的远程新的master分支，还会把本地的master分支和远程的master分支关联起来，在以后的推送或者拉取时就可以简化命令（直接使用git push或git pull）。

以上就是：在电脑上创建<font color=red>*本地仓库*</font>后和github上创建的<font color=red>*远程仓库*</font>的关联的步骤。
