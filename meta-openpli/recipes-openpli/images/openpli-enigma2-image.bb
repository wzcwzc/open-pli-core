require openpli-image.bb

KERNEL_WIFI_DRIVERS = " \
	firmware-carl9170 \
	firmware-htc7010 \
	firmware-htc9271 \
	firmware-rt2870 \
	firmware-rt73 \
	firmware-rtl8712u \
	firmware-zd1211 \
	\
	kernel-module-ath9k-htc \
	kernel-module-carl9170 \
	kernel-module-r8712u \
	kernel-module-rt2500usb \
	kernel-module-rt2800usb \
	kernel-module-rt73usb \
	kernel-module-rtl8187 \
	kernel-module-zd1211rw \
	"

EXTRA_KERNEL_WIFI_DRIVERS = " \
	firmware-rtl8192cu \
	\
	kernel-module-r8188eu \
	kernel-module-rtl8192cu \
	"

EXTERNAL_WIFI_DRIVERS = " \
	firmware-rtl8192cu \
	\
	rtl8192cu \
	rtl8188eu \
	"

ENIGMA2_PLUGINS = " \
	enigma2-plugin-extensions-audiosync \
	enigma2-plugin-extensions-autobackup \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-graphmultiepg \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-openwebif \
	enigma2-plugin-extensions-pictureplayer \
	enigma2-plugin-extensions-ppanel \
	\
	enigma2-plugin-pli-softcamsetup \
	enigma2-plugin-softcams-cccam \
	enigma2-plugin-softcams-mgcamd \
	\
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-systemplugins-satfinder \
	enigma2-plugin-systemplugins-skinselector \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-videomode \
	enigma2-plugin-systemplugins-videotune \
	\
	enigma2-plugin-systemplugins-crossepg \
	\
	${@base_contains("MACHINE_FEATURES", "3dtv", "enigma2-plugin-systemplugins-osd3dsetup" , "", d)} \
	${@base_contains("MACHINE_FEATURES", "dvb-c", "enigma2-plugin-systemplugins-cablescan" , "", d)} \
	${@base_contains("MACHINE_FEATURES", "frontprocessor", "enigma2-plugin-systemplugins-frontprocessorupgrade" , "", d)} \
	${@base_contains("MACHINE_FEATURES", "hdmicec", "enigma2-plugin-systemplugins-hdmicec" , "", d)} \
	${@base_contains("MACHINE_FEATURES", "osdposition", "enigma2-plugin-systemplugins-osdpositionsetup" , "", d)} \
	${@base_contains("MACHINE_FEATURES", "wlan", "enigma2-plugin-systemplugins-wirelesslan", "", d)} \
	\
	${@base_contains('OPENPLI_FEATURES', 'ci', 'enigma2-plugin-systemplugins-commoninterfaceassignment', '', d)} \
	${@base_contains('OPENPLI_FEATURES', 'dvd', 'enigma2-plugin-extensions-cdinfo enigma2-plugin-extensions-dvdplayer', '', d)} \
	${@base_contains('OPENPLI_FEATURES', 'fan', 'enigma2-plugin-systemplugins-tempfancontrol', '', d)} \
	"

DEPENDS += " \
	enigma2 \
	enigma2-pliplugins \
	enigma2-plugins \
	"

ENIGMA2_OPTIONAL = " \
	channelsettings-enigma2-meta \
	enigma2-pliplugins \
	enigma2-plugin-drivers-usbserial \
	enigma2-plugin-extensions-ambx \
	enigma2-plugin-extensions-dlnabrowser \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-et-livestream \
	enigma2-plugin-extensions-openuitzendinggemist \
	enigma2-plugin-extensions-tuxcom \
	enigma2-plugin-extensions-xmltvimport \
	enigma2-plugin-security-firewall \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugins \
	enigma2-skins \
	picons-enigma2-meta \
	softcams-enigma2-meta \
	packagegroup-openplugins \
	${@base_contains("MACHINE_FEATURES", "blindscan-dvbs", "enigma2-plugin-systemplugins-satscan" , "", d)} \
	dvb-usb-drivers-meta \
	cdfs cdtextinfo \
	"

IMAGE_INSTALL += " \
	aio-grab \
	enigma2 \
	oe-alliance-branding \
	libavahi-client \
	settings-autorestore \
	tuxbox-common \
	${ENIGMA2_PLUGINS} \
	\
	${@base_contains("MACHINE_FEATURES", "tpm", "tpmd", "", d)} \
	${@base_contains("MACHINE_FEATURES", "transcoding", "streamproxy", "", d)} \
	${@base_contains('MACHINE_FEATURES', 'ctrlrc', "enigma2-plugin-systemplugins-remotecontrolcode", "", d)} \
	${@base_contains("MACHINE_FEATURES", "kernelwifi", "${KERNEL_WIFI_DRIVERS}", "", d)} \
	${@base_contains("MACHINE_FEATURES", "extrakernelwifi", "${EXTRA_KERNEL_WIFI_DRIVERS}", "", d)} \
	${@base_contains("MACHINE_FEATURES", "externalwifi", "${EXTERNAL_WIFI_DRIVERS}", "", d)} \
	\
	${@base_contains('OPENPLI_FEATURES', 'dvd', 'cdfs cdtextinfo kernel-module-isofs kernel-module-udf', '', d)} \
	"

OPTIONAL_PACKAGES += " \
	${ENIGMA2_OPTIONAL} \
	"

export IMAGE_BASENAME = "openpli-enigma2"
