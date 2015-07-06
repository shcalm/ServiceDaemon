LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := dameon_jni
LOCAL_SRC_FILES :=dameon_jni.c

LOCAL_LDLIBS +=-llog
LOCAL_CFLAGS +=-I.

include $(BUILD_SHARED_LIBRARY)