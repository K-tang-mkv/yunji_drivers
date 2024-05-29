DESCRIPTION = "PCIe Driver Hello World"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14b64611cf1cab389ea8df5d819b9440"

SRC_URI = " \
    file://dw-edma-core.c \
    file://dw-edma-thread.c \
    file://dw-edma-v0-debugfs.c \
    file://dx_cdev_ctrl.c \
    file://dx_sgdma_cdev.c \
    file://Makefile \
    file://virt-dma.c \
    file://dw-edma-pcie.c \
    file://dw-edma-v0-core.c \
    file://dx_cdev.c \
    file://dx_cdev_events.c \
    file://dx_util.c \
    file://include \
    file://LICENSE \
"

S = "${WORKDIR}"

inherit module

DEPENDS += "virtual/kernel glibc libgcc"

do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake
}

do_install() {
    install -d ${S}/extra_ko
    install -m 0644 ${S}/*.ko ${S}/extra_ko
}

FILES_${PN} += "extra_ko/dx_dma.ko"
