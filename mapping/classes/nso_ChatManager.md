# nso.ChatManager

Original JVM class: `bg`.
CLR reference: `ChatManager`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/ChatManager.java`.

## Fields (8)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| bg.aLaa; | chatTabs | ChatManager.chatTabs | reference_proposal | 7 |
| bg.hLbg; | instance | ChatManager.instance | reference_proposal | 9 |
| bg.bI | currentTabIndex | ChatManager.currentTabIndex | reference_proposal | 11 |
| bg.cZ | blockGlobalChat | ChatManager.blockGlobalChat | reference_proposal | 13 |
| bg.dZ | blockPrivateChat | ChatManager.blockPrivateChat | reference_proposal | 15 |
| bg.eZ | isMessageClan | ChatManager.isMessageClan | reference_proposal | 17 |
| bg.fZ | isMessagePt | ChatManager.isMessagePt | reference_proposal | 19 |
| bg.gLaa; | waitList | ChatManager.waitList | reference_proposal | 21 |

## Methods (15)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| bg.a()V | switchToNextTab | ChatManager::switchToNextTab | reference_proposal | 23 |
| bg.b()V | switchToPreviousTab | ChatManager::switchToPreviousTab | reference_proposal | 30 |
| bg.a(I)V | switchToTab | ChatManager::switchToTab | reference_proposal | 37 |
| bg.a(Lbq;)V | switchToTab | ChatManager::switchToTab | reference_proposal | 41 |
| bg.c()V | switchToLastTab | ChatManager::switchToLastTab | reference_proposal | 45 |
| bg.d()Lbg; | gI | ChatManager::gI | reference_proposal | 49 |
| bg.<init>()V | <init> | ChatManager::.ctor | preserved | 53 |
| bg.a(Ljava/lang/String;)Lbq; | findTab | ChatManager::findTab | reference_proposal | 68 |
| bg.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V | addChat | ChatManager::addChat | reference_proposal | 78 |
| bg.e()Lbq; | getCurrentChatTab | ChatManager::getCurrentChatTab | reference_proposal | 86 |
| bg.b(Ljava/lang/String;)Lbq; | addNewTab | ChatManager::addNewTab | reference_proposal | 90 |
| bg.c(Ljava/lang/String;)V | addWaitList | ChatManager::addWaitList | reference_proposal | 99 |
| bg.d(Ljava/lang/String;)Z | findWaitPerson | ChatManager::findWaitPerson | reference_proposal | 108 |
| bg.e(Ljava/lang/String;)V | removeFromWaitList | ChatManager::removeFromWaitList | reference_proposal | 117 |
| bg.f()V | clear | ChatManager::clear | reference_proposal | 126 |
