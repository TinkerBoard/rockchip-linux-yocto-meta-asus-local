DESCRIPTION = "RKNPU Library Built by Rockchip"

LICENSE = "LICENSE.rockchip"
LIC_FILES_CHKSUM = "file://${RKBASE}/licenses/LICENSE.rockchip;md5=d63890e209bf038f44e708bbb13e4ed9"

SRC_URI = "file://librknnrt.so \
           file://librknn_api.so \
"

TARGET_CC_ARCH += "${LDFLAGS}"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_install() {
    install -d ${D}${libdir}
    install -m 0755 ${WORKDIR}/librknnrt.so ${D}${libdir}
    install -m 0755 ${WORKDIR}/librknn_api.so ${D}${libdir}
}

FILES:${PN} += "${libdir}/"
INSANE_SKIP:${PN} = "already-stripped ldflags"
