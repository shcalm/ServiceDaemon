#include <android/log.h>

static const char log_tag[] = "~~~~~~~~~~~~~~~";

#define PPLOG(...) \
    __android_log_print(ANDROID_LOG_DEBUG, log_tag, __VA_ARGS__);
