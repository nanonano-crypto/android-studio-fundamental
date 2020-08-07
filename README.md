# android-studio-fundamental
							

						###	catatan doc resmi android studio
							********************************


* ### link referensi
	* [Doc Resmi grid](https://codelabs.developers.google.com/android-training/)
	* [Doc menu list](https://developer.android.com/courses/fundamentals-training/toc-v2#unit_2_user_experience)
	* [panduan android studio](https://developer.android.com/guide/topics/media?authuser=3)
	* [contoh google(https://github.com/google-developer-training/android-fundamentals-apps-v2)

					Daftar isi
					**********

* ### Unit 1 : Get started

	* Lesson 1: Build your first app
		* 1.1 android studio and Hello World
		* 1.2 part A : Your first interactive UI
		* 1.2 part B : the layout editor
				1. mengenal semua fungsi pada layout editor
				2. membuat tampilan portrait dan landscape menjadi rapi
				3. membuat 2 resource xml
				4. mengenal constrains layout
				5. mengenal relative layout

		* 1.3 text and scrolling views
				1. menggunakan layout scrollview
		* 1.4 learn to help your self
				1. menambahkan icon peluncur 

	* Lesson 2: Activities and intent
		* 2.1 activities and intent
				1. membuat intent dan parsing data
		* 2.2 activities lifecycle and state
				* 
						siklus hidup aktivitas

					Resumed   ( visible ) 			* onResume()
					started   ( visible ) 			* onResume()
					paused    ( partially visible ) * onPaused()
					created   						* onStart()
					stopped   ( hidden ) 			* onStop()
					Destroyed 						* onDestroy()

				* pada saat layar di putar ke landskape maka proses akan di hancurkan dan akan di mulai dari awal lagi, 
				untuk memperthankan nilai bisan menggunakan 

						#############################
						#	 onSaveInstanceState()  #
						#############################

		* 2.3 implisit intent
				* membuat intent  dengan mengarahkan ke aplikasi yg cocok untuk di buka 
				* pada praktek ini akan membuat 
					
					1. buka url di browser 
							ACTION_VIEW  * untuk melihat data yg di berikan
							ACTION_EDIT  * untuk mengedit data yg di berikan
							ACTION_DIAL  * untuk memanggil nomor
							ACTION_IMAGE_CAPTURE * open camera
					2. buka lokasi di map
					3. bagikan text ke sosmed

	* Lesson 3: Testing debugging annd using support libraries
		* 3.1 the debugger
				1. menggunakan Log untuk menampilkan pesan ke panel
				2. mendebug sangat penting untuk  programer karena dengan mendebug kita bisa mencari error denga lebih cepat

		* 3.2 unit test
		* 3.3 support libraries
				1. membuat text berubah warna dengan library yang sudah ada
				2. banyak menyimpan warna di color.xml

* ### Unit 2: User Experience

	* Lesson 4: User interaction
		* 4.1 clickable image
				1. menambahkan gambar ke tata letak

		* 4.2 input control
				1. menambahkan editText, radioButon, dan spinner sabagai latihan
		* 4.3 menus and pickers
				1. menambahkan menu main app
				2. menambahkan dialog 
				3. menambahkan calender
				4. menambahkan jam analog
				
		* 4.4 user navigation
				1. membuat menu navigation

		* 4.5 recycle view

	* Lesson 5:Delightfull user experience
		* 5.1 drawable style and themes

		* 5.2 card and color
		* 5.3 adpative layout

	* Lesson 6. Testing your UI
		* 6.1 espresso for UI testing

* ### Unit 3: working in the background 

	* Lesson 7: background tasks
		* 7.1 asyncTask
		* 7.2 asyncTask and asyncTask Loader
		* 7.3 broadcast receiver

	* Lesson 8: alarm and schedjuler
		* 8.1 Notifications
		* 8.2 the alarm manager
		* 8.3 jobScedjuller

* ### Unit 4:saving user data

	* Lesson 9: preferences and setting 
		* 9.1 shared preferences
		* 9.2 app setting

	* Lesson Storing data with room
		* 10.1 room, live data, and viewModel
		* 10.2 deleting data from a room database

		

