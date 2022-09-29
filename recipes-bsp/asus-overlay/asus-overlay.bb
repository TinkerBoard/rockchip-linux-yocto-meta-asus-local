DESCRIPTION = "ASUS yocto overlay package"

PR = "r1"
SRC_URI = "file://common \
           file://COPYING \
"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=d32239bcb673463ab874e80d47fae504"

do_install() {
  install -d ${D}
  if [ -n "$(ls -A ${WORKDIR}/common)" ]; then
    cp -rf ${WORKDIR}/common/* ${D}
  fi
}

FILES:${PN} += "/ "
