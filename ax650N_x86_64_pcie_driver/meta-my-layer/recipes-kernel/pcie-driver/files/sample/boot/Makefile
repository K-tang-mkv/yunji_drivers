objects = sample_pcie_boot.o
CFLAGS = -g -Wall -O0 -I ../include -I ./zlib/ --sysroot=$(SYSROOT)
LDFLAGS = -L ./zlib/lib -lz -lpthread

sample_pcie_boot : $(objects)
	$(GCC) $(CFLAGS) -o sample_pcie_boot $(objects)  zlib/*.c $(LDFLAGS)

.PHONY : clean
clean :
	rm -f sample_pcie_boot *.o
	rm -f zlib/*.o
