#Git Tutorial

###Initialisierung  
Um ein neues Repository anzulegen wird, nachdem ein Ordner erstellt wurde  
`git init` ausgeführt.   
Nun muss der remote hinzugefügt werden  
`git remote add origin` (origin ist m.w. Konvention, muss aber nicht sein)  

###Add und Commit
Bei änderungen im repository  
`git add fileName`  
nützliche Optionen sind `-A` aus dem root Verzeichnis um alle Dateien hinzuzufügen, oder `--interactive` (Geschmackssache), fileName wird dabei dann nicht angegeben.  
Danach folgt üblicherweise ein  
`git commit` - hier kann man mit `-m "commit message"` direkt die Nachricht angeben.  
Commits sollten so häufig wie möglich gemacht werden (eine neue Methode wäre z.b. einen commit wert). Beim pushen werden automatisch auch alle ungepushten commits mit hoch geladen.  

###Push und Pull
Beim ersten push, damit der remote (origin) gespeichert wird:  
```git push -u origin branch``` (`-u` ist kurz für `--set-upstream`)  
danach einfach nur  
`git push`  
pullen  
`git pull` und ggf. `origin branch` anhängen

`git pull` verwendet ein merge, um Änderungen in den Branch zu holen.
mit `git pull --rebase` wird ein rebase verwendet. Um dieses Verhalten standartmäßig für `git pull`zu aktivieren, gibt es folgenden Befehl: `git config --global branch.autosetuprebase always`

###Branches
`git branch` um die verfügbaren und den aktuell gewählten Branch anzeigen zu lassen.  
`git checkout branchName` wechselt auf den gewünschten Branch, mit  
`git checkout -b branchName` wird automatisch ein neuer erstellt aus dem aktuellen Stand.  
  
Auf alte commits kann auch gebrancht werden:  
`git checkout b1c8210c0c33401cc71718978feb4280ac01e776`  
wechselt auf den entsprechenden commit, jetzt kann man mit `git checkout -b alterStatus` einen neuen Branch mit den Dateien des commits erstellen.  
   
Remote branches können mit dem Befehl   
```git push origin :$BRANCH```   
gelöscht werden.

###Merge
Möchte man zwei branches mergen läuft das in etwa folgendermaßen:

1. Ich gehe auf den branch der 'erweitert' werden soll  
  `git checkout fooBranch`  
2. Pullen, falls nötig  
  `git pull`  
3. Mergen des gewünschten branchs  
  `git merge origin/barBranch`  

Wenn jetzt Konflikte auftreten bleibt einem nichts anderes übrig als diese per Hand zu beheben. Üblicherweise werden Konflikte in einem durch "=" Zeichen getrennten Block angezeigt, der obere Teil stellt die aktuelle Version, der untere die des neuen branches dar.

###Rebase

Um den aktuellen Branch auf dem letzten commit eines anderen Branches starten zu lassen, kann ```git rebase``` ausgeführt werden. Sei ```foo``` der aktuelle Branch und es soll der neueste commit im master benutzt werden:   
```git rebase origin/master```   
Dann werden die commits in branch ```foo``` jetzt beim aktuellen HEAD des branch master starten, so wie er auf dem remote "origin" liegt.   
Um den branch auf dem remote zu aktualisieren muss der lokale nur noch per   
```git push -f origin $BRANCH```   
gepusht werden.   

###Log und status
`git status` zeigt den aktuellen Status an, also uncommitete Änderungen, aktuelle commit message etc.  
`git log` zeigt die commit Historie an (sehr nützlich zum reverten, siehe weiter unten)  

###Revert und Stash
`git revert HEAD~n`, wobei n die Zahl der commits angibt, um die zurück gegangen werden soll.  
`git stash` verstaut alle Änderungen die noch uncommitted sind auf einer Art stack, ein `-u` tut das auch mit Änderungen an untracked files.  
`git stash pop` bzw. `apply` holt den letzten stash wieder hoch, wobei apply den state auf dem stash belässt.  
######ACHTUNG: `git stash` ist global.
Das dient dazu Änderungen von einem Branch in einen anderen zu verschieben (in etwa: ich bin auf feature branch xy und ändere etwas das mit Branch z zu tun hat. Selektiver commit aller sonstigen Änderungen, git stash, checkout auf Branch z, `git stash pop` und dann hier ein commit!).   
mit `pop@{n}` bzw. `apply@{n}` kann der n-te stash geholt werden.  
`git stash list` gibt die auf dem stash liegenden "stashs"  
`git stash clear` löscht alle gestashten states.  

###Allgemeine Arbeitsweise

####Rebase vs Merge
Gnadenlos gestohlen: [stackoverflow - rebase vs. merge](http://stackoverflow.com/questions/804115/git-rebase-vs-git-merge)    

#####Short Version

Merge takes all the changes in one branch and merge them into another branch in one commit.
Rebase says I want the point at which I branched to move to a new starting point
So when do you use either one?

#####Merge

Let's say you have created a branch for the purpose of developing a single feature. When you want to bring those changes back to master, you probably want merge (you don't care about maintaining all of the interim commits).

#####Rebase
A second scenario would be if you started doing some development and then another developer made an unrelated change. You probably want to pull and then rebase to base your changes from the current version from the repo.