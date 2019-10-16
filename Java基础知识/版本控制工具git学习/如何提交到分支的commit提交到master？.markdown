
### 如何提交到分支的commit提交到master？

### 场景说明
    某天，我正在写笔记的时候，由于忘了切换分支。直接将笔记提交到了分支BranchA上，当我发现时，已经晚已。so，如何才能将提交到分支BranchA上的记录，提交到master上？
### 解决
    1. 切换到分支BranchA ,使用``` git log ``` 查看commit 提交的历史记录，记录下提交的hashCode值。
    2. 切换到master分支，使用命令``` git cherry-pick hashCode ```
    3. 使用git push 命令提交到远程仓库

  *错误操作：*当时想着直接切换到master进行，再次提交操作，发现git会提示无文件。这种操作的思想是对git版本管理的思想不了解造成的。
