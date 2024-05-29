DESCRIPTION = "PCIe Driver Hello World"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14b64611cf1cab389ea8df5d819b9440"

SRC_URI = " \
    file://boot/ax_pcie_boot_usrdev.c \
    file://common/ax_pcie_msg_transfer.c \
    file://common/ax_pcie_opt.c \
    file://common/ax_pcie_proc.c \
    file://host_dev/ax_pcie_dev_host.c \
    file://include/ax_pcie_dev.h \
    file://include/ax_pcie_msg_transfer.h \
    file://include/ax_pcie_msg_ursdev.h \
    file://include/ax_pcie_proc.h \
    file://Makefile \
    file://mmb/ax_mmb.c \
    file://mmb/Makefile_arm \
    file://msg/ax_pcie_msg_usrdev.c \
    file://net/ep-net/pci-epf-net.c \
    file://net/include/ax_pcie_net.h \
    file://net/rc-net/ax_pcie_net.c \
    file://sample/boot/Makefile \
    file://sample/boot/sample_pcie_boot.c \
    file://sample/boot/zlib/crc32.h \
    file://sample/boot/zlib/crypt.h \
    file://sample/boot/zlib/deflate.h \
    file://sample/boot/zlib/gzguts.h \
    file://sample/boot/zlib/inffast.h \
    file://sample/boot/zlib/inffixed.h \
    file://sample/boot/zlib/inflate.h \
    file://sample/boot/zlib/inftrees.h \
    file://sample/boot/zlib/ioapi.c \
    file://sample/boot/zlib/ioapi.h \
    file://sample/boot/zlib/lib/libz.so \
    file://sample/boot/zlib/lib/libz.so.1 \
    file://sample/boot/zlib/lib/libz.so.1.2.11 \
    file://sample/boot/zlib/mztools.c \
    file://sample/boot/zlib/mztools.h \
    file://sample/boot/zlib/trees.h \
    file://sample/boot/zlib/unzip.c \
    file://sample/boot/zlib/unzip.h \
    file://sample/boot/zlib/zconf.h \
    file://sample/boot/zlib/zip.c \
    file://sample/boot/zlib/zip.h \
    file://sample/boot/zlib/zlib.h \
    file://sample/boot/zlib/zutil.h \
    file://sample/dma/ax_pcie_dma.c \
    file://sample/dma/Makefile \
    file://sample/dma/mm_buffer.c \
    file://sample/dma/sample_pcie_dma_host.c \
    file://sample/include/ax_base_type.h \
    file://sample/include/ax_pcie_dma_api.h \
    file://sample/include/ax_pcie_msg_api.h \
    file://sample/include/pcie_dma_test.h \
    file://sample/msg/ax_pcie_msg.c \
    file://sample/msg/Makefile \
    file://sample/msg/sample_pcie_msg_host.c \
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

FILES_${PN} += "extra_ko/ax_pcie_boot.ko extra_ko/ax_pcie_host_dev.ko extra_ko/ax_pcie_mmb.ko extra_ko/ax_pcie_msg.ko  extra_ko/ax_pcie_net2.ko"
