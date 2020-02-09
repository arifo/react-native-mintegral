
Pod::Spec.new do |s|
  s.name         = "RNMintegral"
  s.version      = "1.0.0"
  s.summary      = "RNMintegral"
  s.description  = <<-DESC
                  RNMintegral
                   DESC
  s.homepage     = "https://github.com/arifo/react-native-mintegral"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/arifo/react-native-mintegral.git", :tag => "master" }
  s.source_files  = "RNMintegral/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  