## Basic commands 
* Create new branch and switch to it - ``` git checkout -b my-new-branch```

* Push this branch to your fork remote - ``` git push --set-upstream origin JIRA-ID-my-changes```

* Rename branch - 
``` git checkout old-branch
    git branch -m new-branch-name
    git push origin -u new-branch-name | Push the <new_name> local branch and reset the upstream branch
    git push origin --delete old-branch | Delete the <old_name> remote branch
```



## Push changes to someone else PR
``` git remote add john gitUrl
    git fetch john
    git checkout --track -b init-spring-batch john/init-spring-batch
    <commit my changes> / git cherry pick
    git push john init-spring-batch
```    
