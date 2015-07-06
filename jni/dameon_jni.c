#include <jni.h>
#include <unistd.h>
#include "pplog.h"

void Java_com_pp_daemon_DaemonService_startNativeDaemon(
			JNIEnv* env,jobject thiz){
	PPLOG("start ");
	
	if(fork() == 0){//child
		PPLOG("child pid = %d",getpid());
		while(1){
			PPLOG("child process %d" ,getpid());
			sleep(1);
		}
		//exist(0); 
	}else{//father
		PPLOG("father pid = %d",getpid());
		//exist(0);
	}
}
