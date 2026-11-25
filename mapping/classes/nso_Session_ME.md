# nso.Session_ME

Original JVM class: `dh`.
CLR reference: `Session_ME`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Session_ME.java`.

## Fields (21)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| dh.aLdh; | instance | Session_ME.instance | reference_proposal | 11 |
| dh.bZ | unusedSessionFlag |  | behavioral_name | 13 |
| dh.qLjava/io/DataOutputStream; | dos | Session_ME.dos | reference_proposal | 15 |
| dh.cLjava/io/DataInputStream; | dis | Session_ME.dis | reference_proposal | 17 |
| dh.dLan; | messageHandler | Session_ME.messageHandler | reference_proposal | 19 |
| dh.eLjavax/microedition/io/SocketConnection; | sc | Session_ME.sc | reference_proposal | 21 |
| dh.fZ | connected | Session_ME.connected | reference_proposal | 23 |
| dh.gZ | connecting | Session_ME.connecting | reference_proposal | 25 |
| dh.rLaq; | sender | Session_ME.sender | reference_proposal | 27 |
| dh.hLjava/lang/Thread; | initThread | Session_ME.initThread | reference_proposal | 29 |
| dh.iLjava/lang/Thread; | collectorThread | Session_ME.collectorThread | reference_proposal | 31 |
| dh.jI | sendByteCount | Session_ME.sendByteCount | reference_proposal | 33 |
| dh.kI | recvByteCount | Session_ME.recvByteCount | reference_proposal | 35 |
| dh.lZ | getKeyComplete | Session_ME.getKeyComplete | reference_proposal | 37 |
| dh.m[B | key | Session_ME.key | reference_proposal | 39 |
| dh.sB | curR | Session_ME.curR | reference_proposal | 41 |
| dh.tB | curW | Session_ME.curW | reference_proposal | 43 |
| dh.nJ | timeConnected | Session_ME.timeConnected | reference_proposal | 45 |
| dh.oLjava/lang/String; | host | Session_ME.host | reference_proposal | 47 |
| dh.pZ | isCancel | Session_ME.isCancel | reference_proposal | 49 |
| dh.uLaa; | sendQueue |  | behavioral_name | 51 |

## Methods (18)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| dh.<clinit>()V | <clinit> | Session_ME::.cctor | preserved | static/field initializer |
| dh.<init>()V | <init> | Session_ME::.ctor | preserved | 53 |
| dh.a()Ldh; | gI | Session_ME::gI | reference_proposal | 56 |
| dh.b()Z | isConnected | Session_ME::isConnected | reference_proposal | 60 |
| dh.a(Lan;)V | setHandler | Session_ME::setHandler | reference_proposal | 64 |
| dh.a(Ljava/lang/String;)V | connect | Session_ME::connect | reference_proposal | 68 |
| dh.a(Lce;)V | sendMessage | Session_ME::sendMessage | reference_proposal | 78 |
| dh.b(Lce;)V | doSendMessage | Session_ME::doSendMessage | reference_proposal | 84 |
| dh.a(B)B | writeKey | Session_ME::writeKey | reference_proposal | 121 |
| dh.c()V | close | Session_ME::close | reference_proposal | 129 |
| dh.d()V | cleanNetwork | Session_ME::cleanNetwork | reference_proposal | 133 |
| dh.a(Ldh;Ljava/io/DataOutputStream;)V | setOutputStream |  | behavioral_name | 159 |
| dh.a(Ldh;)Laq; | getSender |  | behavioral_name | 163 |
| dh.a(Ldh;Lce;)V | sendMessageNow |  | behavioral_name | 167 |
| dh.a(Ldh;Laa;)V | setSendQueue |  | behavioral_name | 171 |
| dh.b(Ldh;)Laa; | getSendQueue |  | behavioral_name | 175 |
| dh.c(Ldh;)V | cleanNetwork |  | behavioral_name | 179 |
| dh.a(Ldh;B)B | readKey | Session_ME::readKey | reference_proposal | 183 |
