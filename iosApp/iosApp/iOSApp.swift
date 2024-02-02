import SwiftUI
import kmmshared

@main
struct iOSApp: App {
    init(){
        KoinInitializerKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
