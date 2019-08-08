# ShopTemplate

## 工作进度

锁定master分支


### 分支名称

```
branch lzb
branch zsh
branch lxc
```

### 用法

首次，用下面的命令切换到自己的分支

```
git checkout -b lzb // 如： lzb
```

然后，使用下面的命令关联分支

```
git push --set-upstream origin lzb
```

注：第一次，用上面的命令，之后用`git push`即可

其次，在github中建立合并请求

![图示](./pull.gif)

最后，等待其他人的审核通过即可